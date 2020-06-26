package online.luffyk.servlet.home;

import online.luffyk.domain.Product;
import online.luffyk.service.ProductService;
import online.luffyk.service.impl.ProductServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class doProductSelectServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doProductAddServlet.class);
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List<Product> products = productService.showAllProductService();
        if(products.size()>0){
            logger.debug("获取到了所有的信息");
            for (Product product:products){
                logger.debug(product);
            }
            req.setAttribute("products",products);
            req.getRequestDispatcher("/manage/admin_product.jsp").forward(req,resp);
        }else{
            logger.debug("没有获取到所有的信息");
            req.getRequestDispatcher("/manage/admin_product.jsp").forward(req,resp);
        }


    }
}
