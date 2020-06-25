package online.luffyk.servlet.home;

import online.luffyk.domain.Category;
import online.luffyk.service.CategoryService;
import online.luffyk.service.impl.CategoryServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class indexServlet extends HttpServlet {
    private CategoryService categoryService = new CategoryServiceImpl();
    private Logger logger = Logger.getLogger(indexServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("utf-8");
       resp.setContentType("text/html;charset=utf-8");
        List<Category> categories = categoryService.showAllCategoryService();
        if(categories.size()>0){
            logger.debug("获取分类信息成功");
            req.setAttribute("categories",categories);
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else{
            logger.debug("获取分类信息失败");
        }
    }
}
