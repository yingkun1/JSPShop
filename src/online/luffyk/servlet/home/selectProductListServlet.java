package online.luffyk.servlet.home;

import online.luffyk.domain.Category;
import online.luffyk.domain.Product;
import online.luffyk.service.CategoryService;
import online.luffyk.service.ProductService;
import online.luffyk.service.impl.CategoryServiceImpl;
import online.luffyk.service.impl.ProductServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class selectProductListServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(selectProductListServlet.class);
    private CategoryService categoryService = new CategoryServiceImpl();
    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        logger.debug("产品页面");
        int categoryId = -1;
        if( req.getParameter("category_id")!=null){
            categoryId = Integer.parseInt(req.getParameter("category_id"));
        }
        logger.debug("category_id:"+categoryId);
        List<Category> categories = categoryService.showAllCategoryService();
        Category category = categoryService.getCategoryInfoByIdService(categoryId);
        if(category.getCATEGORY_PARENT_ID() == 0){
            logger.debug("根据PID查询");
            List<Product> products = productService.getSomeProductByPIDService(categoryId);
            for(Product product:products){
                logger.debug(product);
            }
        }else{
            //根据CID查询
            logger.debug("根据CID查询");
            List<Product> products = productService.getSomeProductByCIDService(categoryId);
            for(Product product:products){
                logger.debug(product);
            }
        }


        if(categories.size()>0){
            req.setAttribute("category",category);
            req.setAttribute("categories",categories);
            req.getRequestDispatcher("productlist.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("indexservlet").forward(req,resp);
        }

    }
}
