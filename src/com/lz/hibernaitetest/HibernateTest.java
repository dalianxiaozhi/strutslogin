package com.lz.hibernaitetest;

import java.math.BigDecimal;
import java.sql.Date;

import org.hibernate.*;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.Update;
import org.junit.Test;

import com.lz.domain.Employees;
import com.lz.utils.HibernateUtils;
import com.lz.utils.NameGenerator;
import com.lz.utils.RandomName;

public class HibernateTest {

	@Test
	public void testAdd() {

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Date currentDate = new Date(System.currentTimeMillis());
			// 在事务中执行数据库操作，例如保存、更新或删除实体对象
//			Employees empty=new Employees();
//			empty.setId(0001);
//			empty.setFirst_name("liu");
//			empty.setLast_name("zhi");
//			empty.setEmail("dlxiaozhi@hotmail.com");
//			empty.setHire_date(currentDate);
//			empty.setDepartment_id(01);
			NameGenerator nameGenerator = new NameGenerator();

			for (int i = 1; i <= 100; i++) {
				Employees employee = new Employees();
				employee.setId(Integer.parseInt(String.format("%04d", i))); // 使用 %04d 格式化数字，生成四位数的员工编号
				employee.setFirst_name(RandomName.generatefirstName());
				employee.setLast_name(RandomName.generatefirstName());
				employee.setEmail(RandomName.generateFullName()
						+ "@example.com");
				employee.setHire_date(currentDate);
				employee.setDepartment_id(i % 10 + 1); // 部门ID范围为 1-10

				session.save(employee);

				// 每插入10个员工数据，提交一次事务
				if (i % 10 == 0) {
					session.flush();
					session.clear();
					tx.commit();
					tx = session.beginTransaction();
				}
			}

			tx.commit();
			session.close();
		} catch (Exception e) {
			// 发生异常时回滚事务
			tx.rollback();
		} finally {
			// 关闭 Session
			session.close();
		}
	}
}
