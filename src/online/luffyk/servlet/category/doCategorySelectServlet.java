package online.luffyk.servlet.category;

import online.luffyk.domain.Category;
import online.luffyk.service.CategoryService;
import online.luffyk.service.impl.CategoryServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class doCategorySelectServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doCategorySelectServlet.class);
    private CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List<Category> categories = categoryService.showAllCategoryService();
        if(categories.size()>0){
            req.setAttribute("categories",categories);
            req.getRequestDispatcher("/manage/admin_category.jsp").forward(req,resp);
        }else{
            logger.debug("获取分类失败");
        }
    }
}
