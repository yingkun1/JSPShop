package online.luffyk.service.impl;

import online.luffyk.dao.impl.CartDaoImpl;
import online.luffyk.domain.Cart;
import online.luffyk.service.CartService;
import org.apache.log4j.Logger;

public class CartServiceImpl implements CartService {
    private Logger logger = Logger.getLogger(CategoryServiceImpl.class);
    @Override
    public Integer addOneCartService(Cart cart) {
        logger.debug("准备添加一条购物车记录");
        CartDaoImpl cartDao = new CartDaoImpl();
        Integer index = cartDao.addOneCartDao(cart);
        if(index>0){
            logger.debug("添加信息成功");
        }else{
            logger.debug("添加信息失败");
        }
        return index;
    }
}
