package online.luffyk.dao.impl;

import online.luffyk.dao.UserDao;
import online.luffyk.domain.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {
    private Logger logger = Logger.getLogger(UserDaoImpl.class);
    @Override
    public Integer AddOneUserDao(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int index = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215/jspShop?characterEncoding=utf-8&SSL=false", "root", "yingkun9257");
            String sql = "insert into lmonkey_user(USER_ID,USER_NAME,USER_PASSWORD,USER_SEX,USER_BIRTHDAY,USER_IDENTITY_CODE,USER_EMAIL,USER_MOBILE,USER_ADDRESS,USER_STATUS) values(?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUSER_ID());
            preparedStatement.setString(2,user.getUSER_NAME());
            preparedStatement.setString(3,user.getUSER_PASSWORD());
            preparedStatement.setString(4,user.getUSER_SEX());
            preparedStatement.setString(5,user.getUSER_BIRTHDAY());
            preparedStatement.setObject(6,user.getUSER_IDENTITY_CODE(),Types.VARCHAR);
            preparedStatement.setString(7,user.getUSER_EMAIL());
            preparedStatement.setString(8,user.getUSER_MOBILE());
            preparedStatement.setString(9,user.getUSER_ADDRESS());
            preparedStatement.setInt(10,user.getUSER_STATUS());
            index = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return index;
        }
    }

    @Override
    public List<User> showAllUserDao(int count,int currentPage) {
        logger.debug("传递给我的count为："+count);
        logger.debug("传递给我的currentPage为："+currentPage);
        ArrayList<User> users = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "select * from lmonkey_user order by USER_BIRTHDAY DESC LIMIT ?,?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,(currentPage-1)*count);
            preparedStatement.setInt(2,count);
            resultSet = preparedStatement.executeQuery();
            users = new ArrayList<>();
            while (resultSet.next()){
                User user = new User();
                user.setUSER_ID(resultSet.getString("USER_ID"));
                user.setUSER_NAME(resultSet.getString("USER_NAME"));
                user.setUSER_PASSWORD(resultSet.getString("USER_PASSWORD"));
                user.setUSER_SEX(resultSet.getString("USER_SEX"));
                user.setUSER_BIRTHDAY(resultSet.getString("USER_BIRTHDAY"));
                user.setUSER_IDENTITY_CODE(resultSet.getString("USER_IDENTITY_CODE"));
                user.setUSER_EMAIL(resultSet.getString("USER_EMAIL"));
                user.setUSER_MOBILE(resultSet.getString("USER_MOBILE"));
                user.setUSER_ADDRESS(resultSet.getString("USER_ADDRESS"));
                user.setUSER_STATUS(resultSet.getInt("USER_STATUS"));
                users.add(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return users;
        }


    }

    @Override
    public int[] totalNumsAndPagesDao(int count) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int[] total = new int[2];
        int totalNums = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "select count(*) from lmonkey_user";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                totalNums = resultSet.getInt(1);
            }
            int totalPageNums = (int) Math.ceil((double) totalNums / count);
            total[0] = totalNums;
            total[1] = totalPageNums;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return total;
        }
    }
}
