package online.luffyk.service;

import online.luffyk.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> showAllCategoryService();

    Integer addOneCategoryService(String categoryName,Integer categoryId);

    Category getCategoryInfoByIdService(Integer categoryId);

    Integer updateOneCategoryService(Category category);

    Integer deleteOneCategoryByIdService(Integer categoryId);
}
