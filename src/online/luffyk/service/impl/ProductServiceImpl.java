package online.luffyk.service.impl;

import online.luffyk.dao.ProductDao;
import online.luffyk.dao.impl.ProductDaoImpl;
import online.luffyk.domain.Product;
import online.luffyk.service.ProductService;
import org.apache.log4j.Logger;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private Logger logger = Logger.getLogger(ProductServiceImpl.class);
    private  ProductDao productDao = new ProductDaoImpl();

    @Override
    public Integer addOneProductService(Product product) {
        logger.debug("准备插入一个产品的信息");

        Integer index = productDao.addOneProductDao(product);
        if(index>0){
            logger.debug("插入产品信息成功");
        }else{
            logger.debug("插入产品信息失败");
        }
        return index;
    }

    @Override
    public List<Product> showAllProductService() {
        logger.debug("准备获取所有产品的信息");
        List<Product> products = productDao.showAllProductDao();
        if(products.size()>0){
            logger.debug("获取到了所有的信息");
        }else{
            logger.debug("没有获取到所有的信息");
        }
        return products;
    }

    @Override
    public List<Product> getSomeProductByPIDService(Integer PID) {
        logger.debug("准备根据PID查询产品：");
        List<Product> products = productDao.getSomeProductByPIDDao(PID);
        if(products.size()>0){
            logger.debug("获取到了所有PID为:"+PID+"的信息");
        }else{
            logger.debug("没有获取到PID为："+PID+"的信息");
        }
        return products;
    }

    @Override
    public List<Product> getSomeProductByCIDService(Integer CID) {
        logger.debug("准备根据CID查询产品：");
        List<Product> products = productDao.getSomeProductByCIDDao(CID);
        if(products.size()>0){
            logger.debug("获取到了所有CID为:"+CID+"的信息");
        }else{
            logger.debug("没有获取到PID为："+CID+"的信息");
        }
        return products;
    }
}
