package online.luffyk.servlet.cart;

import online.luffyk.service.CartService;
import online.luffyk.service.impl.CartServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class doCartShopNumAddServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doCartShopNumAddServlet.class);
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.sendRedirect("text/html;charset=utf-8");
        int cartId = 0;
        int count1 = 0;

        String count = req.getParameter("count"); //购买的数量
        String cart_id = req.getParameter("cart_id"); //购物id
        logger.debug("count:"+count);
        logger.debug("cart_id:"+cart_id);
        if(cart_id!=null){
            cartId = Integer.parseInt(cart_id);
        }
        if(count!=null){
            count1 = Integer.parseInt(count);
        }
        CartService cartService = new CartServiceImpl();
        Integer index = cartService.updateCartShopNumService(cartId, count1);
        if(index>0){
            logger.debug("更新成功");
        }else{
            logger.debug("更新失败");
        }
    }
}
