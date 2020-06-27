package online.luffyk.dao.impl;

import online.luffyk.dao.CartDao;
import online.luffyk.domain.Cart;

import javax.naming.ldap.PagedResultsControl;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
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

    /**
     *
     * @param uid 用户的id
     * @return 返回所有用户未支付的购物车列表
     */
    @Override
    public List<Cart> allUnpaidCartDao(String uid) {
        ArrayList<Cart> carts = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "select * from lmonkey_cart where CART_U_ID=? AND CART_VALID=1 ORDER BY CART_ID  DESC ;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,uid);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Cart cart = new Cart();
                cart.setCART_ID(resultSet.getInt("CART_ID"));
                cart.setCART_P_FILENAME(resultSet.getString("CART_P_FILENAME"));
                cart.setCART_P_NAME(resultSet.getString("CART_P_NAME"));
                cart.setCART_P_PRICE(resultSet.getInt("CART_P_PRICE"));
                cart.setCART_P_NUMBER(resultSet.getInt("CART_P_NUMBER"));
                cart.setCART_P_STOCK(resultSet.getInt("CART_P_STOCK"));
                cart.setCART_P_ID(resultSet.getInt("CART_P_ID"));
                cart.setCART_U_ID(resultSet.getString("CART_U_ID"));
                cart.setCART_VALID(resultSet.getInt("CART_VALID"));
                carts.add(cart);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return carts;
        }
    }

    /**
     *
     * @param productId 产品ID
     * @return 根据产品ID返回一条购物记录
     */
    @Override
    public Cart getOneCartByIdDao(Integer productId,String uid) {
        Cart cart = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "select * from lmonkey_cart where CART_P_ID=? AND CART_U_ID=? AND CART_VALID=1";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,productId);
            preparedStatement.setString(2,uid);
            System.out.println("sql:"+preparedStatement.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                cart = new Cart();
                cart.setCART_ID(resultSet.getInt("CART_ID"));
                cart.setCART_P_FILENAME(resultSet.getString("CART_P_FILENAME"));
                cart.setCART_P_NAME(resultSet.getString("CART_P_NAME"));
                cart.setCART_P_PRICE(resultSet.getInt("CART_P_PRICE"));
                cart.setCART_P_NUMBER(resultSet.getInt("CART_P_NUMBER"));
                cart.setCART_P_STOCK(resultSet.getInt("CART_P_STOCK"));
                cart.setCART_P_ID(resultSet.getInt("CART_P_ID"));
                cart.setCART_U_ID(resultSet.getString("CART_U_ID"));
                cart.setCART_VALID(resultSet.getInt("CART_VALID"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            return cart;
        }
    }

    @Override
    public Integer updateCartBuyNumberByIdDao(Cart cart) {
        int index = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = " update lmonkey_cart set CART_P_NUMBER=? WHERE CART_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,cart.getCART_P_NUMBER());
            preparedStatement.setInt(2,cart.getCART_ID());
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
    public Integer updateCartShopNumDao(Integer cartId, Integer number) {
        int index = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "update lmonkey_cart set CART_P_NUMBER=? where  CART_ID=? AND CART_VALID=1";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,number);
            preparedStatement.setInt(2,cartId);
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
    public Integer deleteCartShopByIdDao(Integer cartId) {
        int index = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8", "root", "yingkun9257");
            String sql = "delete from lmonkey_cart where CART_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,cartId);
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
    public List<Cart> getOneCartByIdDao(int[] cartIds) {
        ArrayList<Cart> carts = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            for(int value:cartIds){
                String sql = "select * from lmonkey_cart where CART_ID=?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,value);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    Cart cart = new Cart();
                    cart.setCART_ID(resultSet.getInt("CART_ID"));
                    cart.setCART_P_FILENAME(resultSet.getString("CART_P_FILENAME"));
                    cart.setCART_P_NAME(resultSet.getString("CART_P_NAME"));
                    cart.setCART_P_PRICE(resultSet.getInt("CART_P_PRICE"));
                    cart.setCART_P_NUMBER(resultSet.getInt("CART_P_NUMBER"));
                    cart.setCART_P_STOCK(resultSet.getInt("CART_P_STOCK"));
                    cart.setCART_P_ID(resultSet.getInt("CART_P_ID"));
                    cart.setCART_U_ID(resultSet.getString("CART_U_ID"));
                    cart.setCART_VALID(resultSet.getInt("CART_VALID"));
                    carts.add(cart);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return carts;
        }
    }
}
