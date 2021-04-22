package com.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;


    static {
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
        Properties p = new Properties();
//        加载流文件
        try {
            p.load(is);
            driver = p.getProperty("driver");
            url = p.getProperty("url");
            username = p.getProperty("username");
            password = p.getProperty("password");
            Class.forName(driver);
            System.out.println("驱动加载成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("驱动加载失败");
        }


    }

    public static Connection getconnection() {
        try {
            System.out.println("数据库连接成功");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection, Statement statement, ResultSet result) {
        try {
            if (result != null ){
                result.close();
            }
            if (statement != null ){
                statement.close();
            }
            if (connection!= null ){
                connection.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
