package com.dao;

import com.bean.User;
import com.jdbc.JDBCUtils;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    private  static  final String SQL_USER_LOGIN = "SELECT type from info where uname = ? and upass = ?";
    public static final String SQL_USER_INSERT = "insert into info(uname,upass,type) values (?,?,2)";
    public static final String SQL_USER_DELE = "delete from info where uname = ?";
    private static final String SQL_USER_UPDATE = "update info set upass = ? where uname = ?";
    private static final String SQL_USER_SELECT = "select upass,type from info where uname = ?";

    @Override
    public int login(User user) {
        Connection conn = JDBCUtils.getconnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement  = conn.prepareStatement(SQL_USER_LOGIN);
//            设置sql语句的参数
            preparedStatement.setString(1, user.getUname());
            preparedStatement.setString(2, user.getUpass());

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int type = resultSet.getInt("type");
                return type;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }finally {

            JDBCUtils.close(conn,preparedStatement,resultSet );

        }


        return -1;
    }

    @Override
    public boolean insert(User user) {

        Connection conn = JDBCUtils.getconnection();
        PreparedStatement preparedStatement = null;


        try {
            preparedStatement  = conn.prepareStatement(SQL_USER_INSERT);
//            设置sql语句的参数
            preparedStatement.setString(1, user.getUname());
            preparedStatement.setString(2, user.getUpass());
//            返回受影响的数据数量
            int line = preparedStatement.executeUpdate();
            return line>0?true:false;



        } catch (SQLException e){
            e.printStackTrace();
        }finally {

            JDBCUtils.close(conn,preparedStatement,null );

        }

        return false;
    }

    @Override
    public boolean del(String uname) {

        Connection conn = JDBCUtils.getconnection();
        PreparedStatement preparedStatement = null;


        try {
            preparedStatement  = conn.prepareStatement(SQL_USER_DELE);
//            设置sql语句的参数
            preparedStatement.setString(1, uname);

//            返回受影响的数据数量
            int line = preparedStatement.executeUpdate();
            return line>0?true:false;

        } catch (SQLException e){
            e.printStackTrace();
        }finally {

            JDBCUtils.close(conn,preparedStatement,null);

        }

        return false;
    }

    @Override
    public boolean update(User user) {

        Connection conn = JDBCUtils.getconnection();
        PreparedStatement preparedStatement = null;


        try {
            preparedStatement  = conn.prepareStatement(SQL_USER_UPDATE);
//            设置sql语句的参数
            preparedStatement.setString(1, user.getUpass());
            preparedStatement.setString(2, user.getUname());

//            返回受影响的数据数量
            int line = preparedStatement.executeUpdate();
            return line>0?true:false;



        } catch (SQLException e){
            e.printStackTrace();
        }finally {

            JDBCUtils.close(conn,preparedStatement,null );

        }


        return false;
    }

    @Override
    public User select(String uname) {
        Connection conn = JDBCUtils.getconnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement  = conn.prepareStatement(SQL_USER_SELECT);
//            设置sql语句的参数
            preparedStatement.setString(1, uname);


            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String upass = resultSet.getString("upass");

                return new User(uname,upass);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }finally {

            JDBCUtils.close(conn,preparedStatement,resultSet );

        }
        return null;
    }
}
