package online.luffyk.servlet.cart;

import online.luffyk.domain.Cart;
import online.luffyk.domain.User;
import online.luffyk.service.CartService;
import online.luffyk.service.impl.CartServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class OrderConfirmServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(OrderConfirmServlet.class);
    private  CartService cartService = new CartServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user!=null){
            logger.debug("用户已登录");
            String cart_ids = req.getParameter("cart_ids");
            if(cart_ids == null||("").equals(cart_ids)){
                resp.sendRedirect("/JSPShop/showcart");
                return;
            }
            String[] ids = cart_ids.split("-");
            int[] cartIds = new int[ids.length];
            for(int i = 0;i<ids.length;i++){
                cartIds[i] = Integer.parseInt(ids[i]);
            }
            List<Cart> carts = cartService.getOneCartByIdService(cartIds);
            if(carts.size()>0){
                logger.debug("获取成功");
                int sumPrice= 0;
                for(Cart cart:carts){
                    sumPrice+= cart.getCART_P_NUMBER()*cart.getCART_P_PRICE();
                }
                logger.debug("sumPrice="+sumPrice);
                req.setAttribute("sumPrice",sumPrice);
                req.setAttribute("shoplist",carts);
                req.getRequestDispatcher("/order.jsp").forward(req,resp);
            }else{
                logger.debug("获取失败");
                resp.sendRedirect("/JSPShop/showcart");
            }
        }else{
            logger.debug("用户未登录");
            resp.sendRedirect("/JSPShop/login.jsp");
        }


    }
}
