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
    public List<User> showAllUserDao(int count,int currentPage,String keywords) {
        logger.debug("传递给我的count为："+count);
        logger.debug("传递给我的currentPage为："+currentPage);
        logger.debug("传递给我的keywords为："+keywords);
        ArrayList<User> users = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            if(keywords==null || keywords.equals("")){
                String sql = "select * from lmonkey_user order by USER_BIRTHDAY DESC LIMIT ?,?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,(currentPage-1)*count);
                preparedStatement.setInt(2,count);
            }else{
                String sql = "select * from lmonkey_user where USER_NAME like ?  order by USER_BIRTHDAY DESC limit ?,? ;";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,"%"+keywords+"%");
                preparedStatement.setInt(2,(currentPage-1)*count);
                preparedStatement.setInt(3,count);
                logger.debug( preparedStatement.toString());
            }

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
    public int[] totalNumsAndPagesDao(int count,String keywords) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int[] total = new int[2];
        int totalNums = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            if(keywords == null || keywords.equals("")){
                String sql = "select count(*) from lmonkey_user";
                preparedStatement = connection.prepareStatement(sql);
            }else{
                String sql = "select count(*) from lmonkey_user where USER_NAME like ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,"%"+keywords+"%");

            }


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

    @Override
    public User getUserInfoByIdDao(String id) {
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "SELECT m.*, DATE_FORMAT(m.USER_BIRTHDAY,'%Y-%m-%d')BIRTHDAY from lmonkey_user m WHERE USER_ID=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user = new User();
                user.setUSER_ID(resultSet.getString("USER_ID"));
                user.setUSER_NAME(resultSet.getString("USER_NAME"));
                user.setUSER_PASSWORD(resultSet.getString("USER_PASSWORD"));
                user.setUSER_SEX(resultSet.getString("USER_SEX"));
                user.setUSER_BIRTHDAY(resultSet.getString("BIRTHDAY"));
                user.setUSER_IDENTITY_CODE(resultSet.getString("USER_IDENTITY_CODE"));
                user.setUSER_EMAIL(resultSet.getString("USER_EMAIL"));
                user.setUSER_MOBILE(resultSet.getString("USER_MOBILE"));
                user.setUSER_ADDRESS(resultSet.getString("USER_ADDRESS"));
                user.setUSER_STATUS(resultSet.getInt("USER_STATUS"));
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
            return user;
        }
    }

    @Override
    public Integer updateOneUserDao(User user) {
        int index = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "update lmonkey_user SET USER_NAME=?,USER_PASSWORD=?,USER_SEX=?,USER_BIRTHDAY=?,USER_IDENTITY_CODE=?,USER_EMAIL=?,USER_MOBILE=?,USER_ADDRESS=?,USER_STATUS=? where USER_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUSER_NAME());
            preparedStatement.setString(2,user.getUSER_PASSWORD());
            preparedStatement.setString(3,user.getUSER_SEX());
            preparedStatement.setString(4,user.getUSER_BIRTHDAY());
            preparedStatement.setObject(5,user.getUSER_IDENTITY_CODE(),Types.VARCHAR);
            preparedStatement.setString(6,user.getUSER_EMAIL());
            preparedStatement.setString(7,user.getUSER_MOBILE());
            preparedStatement.setString(8,user.getUSER_ADDRESS());
            preparedStatement.setInt(9,user.getUSER_STATUS());
            preparedStatement.setString(10,user.getUSER_ID());
            index = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return index;
        }

    }

    @Override
    public Integer deleteOneUserDao(String id) {
        int index = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "delete from lmonkey_user where USER_ID=? AND  USER_STATUS!=2";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            index = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return index;
        }
    }

    @Override
    public User loginUserDao(String id, String password) {
        User user = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "select * from lmonkey_user where USER_ID=? and USER_PASSWORD=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user = new User();
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
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return user;
        }
    }
}
