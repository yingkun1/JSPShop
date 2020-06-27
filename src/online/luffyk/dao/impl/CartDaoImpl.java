package online.luffyk.dao.impl;

import online.luffyk.dao.CartDao;
import online.luffyk.domain.Cart;

import javax.naming.ldap.PagedResultsControl;
import java.sql.*;

public class CartDaoImpl implements CartDao {
    @Override
    public Integer addOneCartDao(Cart cart) {
        int index = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "insert into lmonkey_cart(CART_ID,CART_P_FILENAME,CART_P_NAME,CART_P_PRICE,CART_P_NUMBER,CART_P_STOCK,CART_P_ID,CART_U_ID,CART_VALID) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,cart.getCART_ID(), Types.INTEGER);
            preparedStatement.setString(2,cart.getCART_P_FILENAME());
            preparedStatement.setString(3,cart.getCART_P_NAME());
            preparedStatement.setInt(4,cart.getCART_P_PRICE());
            preparedStatement.setInt(5,cart.getCART_P_NUMBER());
            preparedStatement.setInt(6,cart.getCART_P_STOCK());
            preparedStatement.setInt(7,cart.getCART_P_ID());
            preparedStatement.setString(8,cart.getCART_U_ID());
            preparedStatement.setInt(9,cart.getCART_VALID());
            index = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return index;
        }
    }
}
