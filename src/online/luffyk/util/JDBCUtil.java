package online.luffyk.util;

import java.sql.*;

public class JDBCUtil{
    private static Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    //加载驱动
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection(){
        if(connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    //关闭资源
    public static void closeAll(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
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

    }
}
