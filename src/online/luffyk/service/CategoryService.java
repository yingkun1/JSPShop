package online.luffyk.service;

import online.luffyk.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> showAllCategoryService();

    List<Category> showAllCategoryService(int count,int currentPage,String keywords);

    Integer addOneCategoryService(String categoryName,Integer categoryId);

    Category getCategoryInfoByIdService(Integer categoryId);

    Integer updateOneCategoryService(Category category);

    Integer deleteOneCategoryByIdService(Integer categoryId);

    int[] totalNumsAndPagesService(int count,String keywords);
}
