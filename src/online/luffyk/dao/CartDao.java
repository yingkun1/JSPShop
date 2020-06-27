package online.luffyk.dao;

import online.luffyk.domain.Cart;

import java.util.List;

public interface CartDao {
    Integer addOneCartDao(Cart cart);

    /**
     *
     * @param uid 用户的id
     * @return 返回所有用户未支付的商品
     */
    List<Cart> allUnpaidCartDao(String uid);

    /**
     *
     * @param productId 产品ID
     * @return 根据产品ID返回一条购物记录
     */
    Cart  getOneCartByIdDao(Integer productId,String uid);

    Integer updateCartBuyNumberByIdDao(Cart cart);

    Integer updateCartShopNumDao(Integer cartId,Integer number);

    Integer deleteCartShopByIdDao(Integer cartId);
}
