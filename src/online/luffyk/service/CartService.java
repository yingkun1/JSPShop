package online.luffyk.service;

import online.luffyk.domain.Cart;

import java.util.List;

public interface CartService {
    Integer addOneCartService(Cart cart);

    /**
     *
     * @param uid 用户的id
     * @return 返回所有用户未支付的商品列表
     */
    List<Cart> allUnpaidCartService(String uid);

    /**
     *
     * @param productId 产品ID
     * @return 返回一条购物车记录
     */
    Cart getOneCartByIdService(Integer productId,String uid);

    Integer updateCartBuyNumberByIdService(Cart cart);

    Integer updateCartShopNumService(Integer cartId,Integer number);

    Integer deleteCartShopByIdService(Integer cartId);

    List<Cart> getOneCartByIdService(int[] cartIds);

}
