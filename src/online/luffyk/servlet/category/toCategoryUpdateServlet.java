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

public class toCategoryUpdateServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(toCategoryUpdateServlet.class);
    private CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int categoryId = -1;
        if(req.getParameter("category_id")!=null){
            categoryId = Integer.parseInt(req.getParameter("category_id"));
        }
        logger.debug("category_id:"+categoryId);
        Category category = categoryService.getCategoryInfoByIdService(categoryId);
        List<Category> categories = categoryService.showAllCategoryService();
        if(category!=null){
            logger.debug("获取成功");
            req.setAttribute("category",category);
            req.setAttribute("categories",categories);
            req.getRequestDispatcher("/manage/admin_categorymodify.jsp").forward(req,resp);
        }else{
            logger.debug("获取失败");
            resp.sendRedirect("/JSPShop/admin_categoryselect");
        }
    }
}
