package online.luffyk.servlet.cart;

import online.luffyk.domain.Cart;
import online.luffyk.domain.Product;
import online.luffyk.domain.User;
import online.luffyk.service.CartService;
import online.luffyk.service.ProductService;
import online.luffyk.service.impl.CartServiceImpl;
import online.luffyk.service.impl.ProductServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class doAddCartServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doAddCartServlet.class);
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String product_id = req.getParameter("product_id");
        String count = req.getParameter("count");
        String target = req.getParameter("target");
        logger.debug("product_id:"+product_id);
        logger.debug("count:"+count);
        logger.debug("target:"+target);
        
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user!=null){
            String uid = user.getUSER_ID();
            int productId = -1;
            int count1 = -1;
            if(product_id!=null){
                productId = Integer.parseInt(product_id);
            }
            if(count!=null){
                count1 = Integer.parseInt(count);
            }
            ProductService productService = new ProductServiceImpl();
            Product product = productService.getProductByIDService(productId);
            if(product!=null){
                Cart cart = new Cart(null, product.getPRODUCT_FILENAME(), product.getPRODUCT_NAME(), product.getPRODUCT_PRICE(), count1, product.getPRODUCT_STOCK(), productId, uid, 1);
                logger.debug(cart);
                CartService cartService = new CartServiceImpl();
                Integer index = cartService.addOneCartService(cart);
                if(index>0){
                    logger.debug("添加购物车信息成功");
                    req.setAttribute("cart",cart);
//                    req.getRequestDispatcher("").forward(req,resp);
                }else{
                    logger.debug("添加购物车信息失败");
                }
            }
        }else{
            req.getRequestDispatcher("login.jsp");
        }


    }
}
