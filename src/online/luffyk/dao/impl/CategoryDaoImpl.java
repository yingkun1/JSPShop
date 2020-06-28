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
    public List<Category> showAllCategoryDao(int count, int currentPage,String keywords) {
        ArrayList<Category> categories = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            if(keywords == null || keywords.equals("")){
                String sql = "select * from lmonkey_category limit ?,?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,(currentPage-1)*count);
                preparedStatement.setInt(2,count);
            }else{
                String sql = "select * from lmonkey_category where CATEGORY_NAME like ? limit ?,?;";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,"%"+keywords+"%");
                preparedStatement.setInt(2,(currentPage-1)*count);
                preparedStatement.setInt(3,count);
            }
            System.out.println(preparedStatement.toString());
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

    @Override
    public int[] totalNumsAndPagesDao(int count,String keywords) {
        int totalNums = 0;
        int totalPages = 0;
        int[] totals = new int[2];
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://101.132.138.215:3306/jspShop?characterEncoding=utf-8&useSSL=false", "root", "yingkun9257");
            if(keywords == null || keywords.equals("")){
                String sql = " select count(*) from lmonkey_category";
                preparedStatement = connection.prepareStatement(sql);
            }else{
                String sql = "select count(*) from lmonkey_category where CATEGORY_NAME like ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,"%"+keywords+"%");
                System.out.println(preparedStatement.toString());
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                totalNums = resultSet.getInt(1);
            }
            totalPages = (int)Math.ceil((double) totalNums / count);
            totals[0] = totalNums;
            totals[1] = totalPages;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return totals;
        }
    }
}
