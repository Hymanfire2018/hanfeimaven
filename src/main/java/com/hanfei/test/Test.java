package com.hanfei.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/db1?useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String pwd = "root";

        Connection conn = DriverManager.getConnection(url, user, pwd);

        String sql = "SELECT * FROM t_user WHERE USER_ID = 1 ";

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            System.out.println(rs.getInt("USER_ID")+"---"+rs.getString("USER_ID")+"---"+rs.getString("USER_PASSWORD"));
        }

        rs.close();
        ps.close();
        conn.close();
    }
}


