package online.luffyk.dao;

import online.luffyk.domain.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> showAllCategoryDao();

    List<Category> showAllCategoryDao(int count,int currentPage,String keywords);

    Integer addOneCategoryDao(String categoryName,Integer categoryId);

    Category getCategoryInfoByIdDao(Integer categoryId);

    Integer updateOneCategoryDao(Category category);

    Integer deleteOneCategoryByIdDao(Integer categoryId);

    int[] totalNumsAndPagesDao(int count,String keywords);
}
