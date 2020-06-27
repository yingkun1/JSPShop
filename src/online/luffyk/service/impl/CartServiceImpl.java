package online.luffyk.service.impl;

import online.luffyk.dao.impl.CartDaoImpl;
import online.luffyk.domain.Cart;
import online.luffyk.service.CartService;
import org.apache.log4j.Logger;

import java.util.List;

public class CartServiceImpl implements CartService {
    private Logger logger = Logger.getLogger(CategoryServiceImpl.class);
    private CartDaoImpl cartDao = new CartDaoImpl();
    @Override
    public Integer addOneCartService(Cart cart) {
        logger.debug("准备添加一条购物车记录");
        Integer index = cartDao.addOneCartDao(cart);
        if(index>0){
            logger.debug("添加信息成功");
        }else{
            logger.debug("添加信息失败");
        }
        return index;
    }

    /**
     *
     * @param uid 用户的id
     * @return 用户未支付的商品列表
     */
    @Override
    public List<Cart> allUnpaidCartService(String uid) {
        logger.debug("根据用户id:"+uid+"获取购物车中未支付的产品");
        List<Cart> carts = cartDao.allUnpaidCartDao(uid);
        if(carts.size()>0){
            logger.debug("获取到了购物车中未支付的产品");
        }else{
            logger.debug("没有获取到购物车中未支付的产品");
        }
        return carts;
    }

    @Override
    public Cart getOneCartByIdService(Integer productId,String uid) {
        logger.debug("根据产品ID"+productId+"返回数据库中对应的购物记录");
        Cart cart = cartDao.getOneCartByIdDao(productId,uid);
        if(cart!=null){
            logger.debug("获取到了对应的购物记录");
        }else{
            logger.debug("没有获取到对应的购物记录");
        }
        return cart;
    }

    @Override
    public Integer updateCartBuyNumberByIdService(Cart cart) {
        logger.debug("修改购买的数量");
        Integer index = cartDao.updateCartBuyNumberByIdDao(cart);
        if(index>0){
            logger.debug("更新成功");
        }else{
            logger.debug("更新失败");
        }
        return index;
    }

    @Override
    public Integer updateCartShopNumService(Integer cartId, Integer number) {
        logger.debug("通过ajax更新购物车中商品的数量");
        Integer index = cartDao.updateCartShopNumDao(cartId, number);
        if(index>0){
            logger.debug("更新成功");
        }else{
            logger.debug("更新失败");
        }
        return index;
    }

    @Override
    public Integer deleteCartShopByIdService(Integer cartId) {
        logger.debug("准备从数据库中删除一条购物车记录");
        Integer index = cartDao.deleteCartShopByIdDao(cartId);
        if(index>0){
            logger.debug("删除成功");
        }else{
            logger.debug("删除失败");
        }
        return index;
    }

    @Override
    public List<Cart> getOneCartByIdService(int[] cartIds) {
        logger.debug("准备根据cartId从数据库中获取购物车的信息");
        List<Cart> carts = cartDao.getOneCartByIdDao(cartIds);
        if(carts.size()>0){
            logger.debug("获取到了数据库中购物车的信息");
        }else{
            logger.debug("没有获取到数据中购物车的信息");
        }
        return carts;
    }


}
