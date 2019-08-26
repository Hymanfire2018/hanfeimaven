package com.hanfei.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanfei.domain.User;

public class Test1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/db1?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8";
        String user = "root";
        String pwd = "root";

        	
        Connection conn = DriverManager.getConnection(url, user, pwd);

        Statement stmt = conn.createStatement();

        String sql = "SELECT * FROM t_user";
        ResultSet rs = stmt.executeQuery(sql);

        List<User> list = new ArrayList<User>();
        while(rs.next()){
            int id = rs.getInt("USER_ID");
            String name = rs.getString("USER_NAME");
            String password = rs.getString("USER_PASSWORD");
            User u = new User(id, name,password);
            list.add(u);
        }

        System.out.println(list.toString());
    }
}

