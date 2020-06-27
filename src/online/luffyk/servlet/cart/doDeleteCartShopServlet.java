package online.luffyk.servlet.cart;

import online.luffyk.service.CartService;
import online.luffyk.service.impl.CartServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class doDeleteCartShopServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doDeleteCartShopServlet.class);
    private CartService cartService = new CartServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String cart_id = req.getParameter("cart_id");
        logger.debug("cart_id:"+cart_id);
        if(cart_id!=null){
            Integer index = cartService.deleteCartShopByIdService(Integer.parseInt(cart_id));
            if(index>0){
                logger.debug("删除成功");
                resp.sendRedirect("/JSPShop/showcart");
            }else{
                logger.debug("删除失败");
                resp.sendRedirect("/JSPShop/showcart");
            }
        }
    }
}
