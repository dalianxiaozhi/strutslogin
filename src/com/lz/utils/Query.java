package com.lz.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query {
    public static void main(String[] args) {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        try {
            //1、获取连接对象
            conn=OracleSQLHelper.getconn();
            //2、创建statement类对象，用来执行SQL语句
            st=conn.createStatement();
            //3、创建sql查询语句
            String sql="select *from users";
            //4、执行sql语句并且换回一个查询的结果集
            rs=st.executeQuery(sql);
            while(rs.next()) {  //循环遍历结果集
                int userId=rs.getInt("user_id");
                String username=rs.getString("username");
                String password=rs.getString("password");
                System.out.println("我是"+username+",编号"+userId+",password是"+password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
