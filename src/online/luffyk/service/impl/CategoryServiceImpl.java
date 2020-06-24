package online.luffyk.service.impl;

import online.luffyk.dao.CategoryDao;
import online.luffyk.dao.impl.CategoryDaoImpl;
import online.luffyk.domain.Category;
import online.luffyk.service.CategoryService;
import org.apache.log4j.Logger;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private Logger logger = Logger.getLogger(CategoryServiceImpl.class);
    private  CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> showAllCategoryService() {
        logger.debug("准备查询所有的分类");
        List<Category> categories = categoryDao.showAllCategoryDao();
        if(categories.size()>0){
            logger.debug("获取到了所有的分类");
        }else{
            logger.debug("获取分类失败");
        }
        return categories;


    }

    @Override
    public Integer addOneCategoryService(String categoryName,Integer categoryId) {
        logger.debug("准备添加一个分类");
        Integer index = categoryDao.addOneCategoryDao(categoryName, categoryId);
        if(index>0){
            logger.debug("添加分类："+categoryName+"成功");
        }else{
            logger.debug("添加分类:"+categoryName+"失败");
        }
        return index;
    }
}
