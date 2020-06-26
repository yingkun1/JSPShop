package online.luffyk.dao.impl;

import online.luffyk.dao.ProductDao;
import online.luffyk.domain.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public Integer addOneProductDao(Product product) {
        int index = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "insert into lmonkey_product(PRODUCT_ID,PRODUCT_NAME,PRODUCT_DESCRIPTION,PRODUCT_PRICE,PRODUCT_STOCK,PRODUCT_PID,PRODUCT_CID,PRODUCT_FILENAME) values(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1,product.getPRODUCT_ID(), Types.INTEGER);
            preparedStatement.setString(2,product.getPRODUCT_NAME());
            preparedStatement.setString(3,product.getPRODUCT_DESCRIPTION());
            preparedStatement.setInt(4,product.getPRODUCT_PRICE());
            preparedStatement.setInt(5,product.getPRODUCT_STOCK());
            preparedStatement.setInt(6,product.getPRODUCT_PID());
            preparedStatement.setInt(7,product.getPRODUCT_CID());
            preparedStatement.setString(8,product.getPRODUCT_FILENAME());
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
    public List<Product> showAllProductDao() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "select * from lmonkey_product";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product = new Product();
                product.setPRODUCT_ID(resultSet.getInt("PRODUCT_ID"));
                product.setPRODUCT_NAME(resultSet.getString("PRODUCT_NAME"));
                product.setPRODUCT_DESCRIPTION(resultSet.getString("PRODUCT_DESCRIPTION"));
                product.setPRODUCT_PRICE(resultSet.getInt("PRODUCT_PRICE"));
                product.setPRODUCT_STOCK(resultSet.getInt("PRODUCT_STOCK"));
                product.setPRODUCT_PID(resultSet.getInt("PRODUCT_PID"));
                product.setPRODUCT_CID(resultSet.getInt("PRODUCT_CID"));
                product.setPRODUCT_FILENAME(resultSet.getString("PRODUCT_FILENAME"));
                products.add(product);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return products;
        }
    }

    @Override
    public List<Product> getSomeProductByPIDDao(Integer PID) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "select * from lmonkey_product where PRODUCT_PID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,PID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product = new Product();
                product.setPRODUCT_ID(resultSet.getInt("PRODUCT_ID"));
                product.setPRODUCT_NAME(resultSet.getString("PRODUCT_NAME"));
                product.setPRODUCT_DESCRIPTION(resultSet.getString("PRODUCT_DESCRIPTION"));
                product.setPRODUCT_PRICE(resultSet.getInt("PRODUCT_PRICE"));
                product.setPRODUCT_STOCK(resultSet.getInt("PRODUCT_STOCK"));
                product.setPRODUCT_PID(resultSet.getInt("PRODUCT_PID"));
                product.setPRODUCT_CID(resultSet.getInt("PRODUCT_CID"));
                product.setPRODUCT_FILENAME(resultSet.getString("PRODUCT_FILENAME"));
                products.add(product);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return products;
        }
    }

    @Override
    public List<Product> getSomeProductByCIDDao(Integer CID) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "select * from lmonkey_product where PRODUCT_CID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,CID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product = new Product();
                product.setPRODUCT_ID(resultSet.getInt("PRODUCT_ID"));
                product.setPRODUCT_NAME(resultSet.getString("PRODUCT_NAME"));
                product.setPRODUCT_DESCRIPTION(resultSet.getString("PRODUCT_DESCRIPTION"));
                product.setPRODUCT_PRICE(resultSet.getInt("PRODUCT_PRICE"));
                product.setPRODUCT_STOCK(resultSet.getInt("PRODUCT_STOCK"));
                product.setPRODUCT_PID(resultSet.getInt("PRODUCT_PID"));
                product.setPRODUCT_CID(resultSet.getInt("PRODUCT_CID"));
                product.setPRODUCT_FILENAME(resultSet.getString("PRODUCT_FILENAME"));
                products.add(product);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return products;
        }
    }
}
