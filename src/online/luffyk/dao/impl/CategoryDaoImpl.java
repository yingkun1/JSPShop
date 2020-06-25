package online.luffyk.dao.impl;

import online.luffyk.dao.CategoryDao;
import online.luffyk.domain.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<Category> showAllCategoryDao() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "select * from lmonkey_category";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Category category = new Category();
                category.setCATEGORY_ID(resultSet.getInt("CATEGORY_ID"));
                category.setCATEGORY_NAME(resultSet.getString("CATEGORY_NAME"));
                category.setCATEGORY_PARENT_ID(resultSet.getInt("CATEGORY_PARENT_ID"));
                categories.add(category);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return categories;
        }
    }

    @Override
    public Integer addOneCategoryDao(String categoryName,Integer categoryId) {
        int index = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "insert into lmonkey_category(CATEGORY_NAME,CATEGORY_PARENT_ID) values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,categoryName);
            preparedStatement.setInt(2,categoryId);
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
    public Category getCategoryInfoByIdDao(Integer categoryId) {
        Category category = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "select * from lmonkey_category where CATEGORY_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                category = new Category();
                category.setCATEGORY_ID(resultSet.getInt("CATEGORY_ID"));
                category.setCATEGORY_NAME(resultSet.getString("CATEGORY_NAME"));
                category.setCATEGORY_PARENT_ID(resultSet.getInt("CATEGORY_PARENT_ID"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return category;
        }
    }

    @Override
    public Integer updateOneCategoryDao(Category category) {
        int index = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "update lmonkey_category set CATEGORY_NAME=?,CATEGORY_PARENT_ID=? WHERE CATEGORY_ID=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,category.getCATEGORY_NAME());
            preparedStatement.setInt(2,category.getCATEGORY_PARENT_ID());
            preparedStatement.setInt(3,category.getCATEGORY_ID());
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
    public Integer deleteOneCategoryByIdDao(Integer categoryId) {
        int index = -1;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            String sql = "delete from lmonkey_category where CATEGORY_ID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,categoryId);
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
