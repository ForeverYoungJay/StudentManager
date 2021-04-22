package com.test;

import com.jdbc.JDBCUtils;

import java.sql.*;

public class JDBCUtilsTest {

    public void jdbcConnectionTest() throws Exception {
        Connection conn = JDBCUtils.getconnection();
        Statement statement =  conn.createStatement();
        ResultSet result = statement.executeQuery("select * from info");
        while (result.next()){
            System.out.println(result.getInt("id"));
        }

    }

    public static void close(Connection connection,Statement statement,ResultSet result) {
        try {
            if (result != null ){
                result.close();
                result = null;
            }
            if (statement != null ){
                statement.close();
                statement = null;
            }
            if (connection!= null ){
                connection.close();
                connection= null;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static class JDBCTest {
        public static void jdbcConnectionTest(){
            Connection conn = JDBCUtils.getconnection();
            try {
                PreparedStatement ps = conn.prepareStatement("select * from emp where id = 1");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    System.out.println(rs.getInt("id")+"--"+rs.getString("empname"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("查询完毕");
        }

        public static void main(String[] args) {
            jdbcConnectionTest();
        }
    }

}
