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
    private  CartService cartService = new CartServiceImpl();
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
            logger.debug("用户已登录");
            String uid = user.getUSER_ID();
            int productId = -1;
            int count1 = -1;
            if(product_id!=null){
                productId = Integer.parseInt(product_id);
            }
            if(count!=null){
                count1 = Integer.parseInt(count);
            }
            //根据productId去数据库的购物车表中查询一下，是否已经添加了这个商品，如果添加了，返回这条记录;
            //修改这条记录的CART_P_NUMBER值
            Cart cart1 = cartService.getOneCartByIdService(productId,uid);
            logger.debug(cart1);
            if(cart1!=null){
                logger.debug("该购物记录已存在,修改购买的数值");
                int newNumber = cart1.getCART_P_NUMBER() + count1;
                if(newNumber<5){
                    cart1.setCART_P_NUMBER(newNumber);
                }else{
                    cart1.setCART_P_NUMBER(5);
                }

                Integer index = cartService.updateCartBuyNumberByIdService(cart1);
                this.cartJump(index,target,resp,productId);
            }else{
                logger.debug("该购物记录不存在");
                ProductService productService = new ProductServiceImpl();
                Product product = productService.getProductByIDService(productId);
                if(product!=null){
                    Cart cart = new Cart(null, product.getPRODUCT_FILENAME(), product.getPRODUCT_NAME(), product.getPRODUCT_PRICE(), count1, product.getPRODUCT_STOCK(), productId, uid, 1);
                    logger.debug(cart);
                    Integer index = cartService.addOneCartService(cart);
                    this.cartJump(index,target,resp,productId);
                }
            }
        }else{
            logger.debug("用户未登录");
            req.getRequestDispatcher("login.jsp");
        }
    }

    private void cartJump(int index,String target,HttpServletResponse resp,int product_id) throws IOException {
        if(index>0){
            logger.debug("更新成功");
            if(target.equals("buyNow")){
                resp.sendRedirect("/JSPShop/showcart");
            }else{
                resp.sendRedirect("/JSPShop/selectproductdetail?product_id="+product_id);
            }
        }else{
            logger.debug("更新失败");
            resp.sendRedirect("/JSPShop/selectproductdetail?product_id="+product_id);
        }
    }
}
