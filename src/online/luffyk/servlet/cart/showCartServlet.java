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

public class showCartServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(showCartServlet.class);
    private CartService cartService = new CartServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user!=null){
            logger.debug("用户已经登录：用户名为："+user.getUSER_NAME());
            //去数据库中根据用户的UID获取未购买的商品
            List<Cart> carts = cartService.allUnpaidCartService(user.getUSER_ID());
            if(carts.size()>0){
                logger.debug("获取到了未支付的商品");
                req.setAttribute("carts",carts);
                req.getRequestDispatcher("/cart.jsp").forward(req,resp);
            }else{
                logger.debug("未获取到未支付的商品");
                req.setAttribute("carts",carts);
                req.getRequestDispatcher("/cart.jsp").forward(req,resp);
            }
        }else{
            logger.debug("用户未登录，重定向到登录页面");
            resp.sendRedirect("/JSPShop/login.jsp");
        }
    }
}
