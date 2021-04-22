package com.jdbc;

import java.sql.*;

public class jdbc {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","root");
            System.out.println("yes");
            Statement statement =  conn.createStatement();
            ResultSet result = statement.executeQuery("select * from info");
            while (result.next()){
                System.out.println(result.getInt("id"));
                System.out.println(result.getString("uname"));
            }
        }
        catch (Exception e){
        e.printStackTrace();
        System.out.println("NO");
        }
    }
}
