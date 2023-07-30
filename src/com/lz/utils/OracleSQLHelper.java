package com.lz.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OracleSQLHelper {

	    static String driverClass="oracle.jdbc.driver.OracleDriver"; //oracle的驱动
	    static String url="jdbc:oracle:thin:@localhost:1521:orcl";// port sid
	    static String user="Admin123";   //user是数据库的用户名
	    static String password="abc123";  //用户登录密码

	    public static Connection getconn() {
	        Connection conn=null;
	        try {
	            //首先建立驱动
	            Class.forName("oracle.jdbc.driver.OracleDriver");//反射
	            //驱动成功后进行连接
	            conn=DriverManager.getConnection(url, user, password);

	            System.out.println("连接成功");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return conn; //返回一个连接
	    }
	}
