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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class selectProductDetailServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(selectProductDetailServlet.class);
    ArrayList<Product> recentlyVisitedProducts = new ArrayList<>();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int product_id = -1 ;
        if(req.getParameter("product_id")!=null){
            product_id = Integer.parseInt(req.getParameter("product_id"));
        }


        ProductService productService = new ProductServiceImpl();
        Product product = productService.getProductByIDService(product_id);
        CategoryService categoryService = new CategoryServiceImpl();
        if(product!=null){
            logger.debug("获取成功");
            logger.debug(product);

            this.genRecentlyVisitedProducts(product,req,5);

            Integer product_cid = product.getPRODUCT_CID();
            List<Product> products = productService.getSomeProductByCIDService(product_cid);
            Category twoLevelCategory = categoryService.getCategoryInfoByIdService(product_cid);
            List<Category> categories = categoryService.showAllCategoryService();
            logger.debug("twoLevelCategory:"+twoLevelCategory);

            req.setAttribute("categories",categories);
            req.setAttribute("twoLevelCategory",twoLevelCategory);
            req.setAttribute("products",products);
            req.setAttribute("product",product);
            req.getRequestDispatcher("/productDetail.jsp").forward(req,resp);
        }else{
            logger.debug("获取失败");
            req.getRequestDispatcher("/selectproductlist").forward(req,resp);
        }
    }

    private void genRecentlyVisitedProducts(Product product,HttpServletRequest req,int capacity){
        //使用session保存最近访问的数据
        boolean flag = true;
        for(Product product1:recentlyVisitedProducts){
            if(product1.getPRODUCT_NAME().equals(product.getPRODUCT_NAME())){
                flag = false;
            }
        }
        if(flag){
            if(recentlyVisitedProducts.size()==capacity){
                recentlyVisitedProducts.remove(0);
            }
            recentlyVisitedProducts.add(product);
            logger.debug("recentlyVisitedProducts:"+recentlyVisitedProducts);
            HttpSession session = req.getSession();
            session.setAttribute("recentlyVisitedProducts",recentlyVisitedProducts);
        }
    }
}
