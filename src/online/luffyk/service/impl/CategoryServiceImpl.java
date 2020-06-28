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
    public List<Category> showAllCategoryService(int count, int currentPage,String keywords) {
        logger.debug("准备进行分页查询");
        List<Category> categories = categoryDao.showAllCategoryDao(count, currentPage,keywords);
        if(categories.size()>0){
            logger.debug("根据分页获取到了分类信息");
        }else{
            logger.debug("根据分页的方式没有获取到分类的信息");
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

    @Override
    public Category getCategoryInfoByIdService(Integer categoryId) {
        logger.debug("准备根据categoryId："+categoryId+"获取分类信息");
        Category category = categoryDao.getCategoryInfoByIdDao(categoryId);
        if(category!=null){
            logger.debug("获取分类信息成功");
        }else{
            logger.debug("获取分类信息失败");
        }
        return category;

    }

    @Override
    public Integer updateOneCategoryService(Category category) {
        logger.debug("准备跟新一个分类，分类id为："+category.getCATEGORY_ID());
        Integer index = categoryDao.updateOneCategoryDao(category);
        if(index>0){
            logger.debug("更新分类信息成功");
        }else{
            logger.debug("更新分类信息失败");
        }
        return index;

    }

    @Override
    public Integer deleteOneCategoryByIdService(Integer categoryId) {
        logger.debug("准备删除一个分类，分类id为："+categoryId);
        Integer index = categoryDao.deleteOneCategoryByIdDao(categoryId);
        if(index >0){
            logger.debug("删除成功");
        }else{
            logger.debug("删除失败");
        }
        return index;
    }

    @Override
    public int[] totalNumsAndPagesService(int count,String keywords) {
        logger.debug("准备根据count值获取总记录数和总页数");
        int[] totalNumsAndPages = categoryDao.totalNumsAndPagesDao(count,keywords);
        if(totalNumsAndPages[0]>0 && totalNumsAndPages[1]>0){
            logger.debug("获取到了总条数和总页数");
        }else{
            logger.debug("没有获取到总条数和总页数");
        }
        return totalNumsAndPages;
    }
}
