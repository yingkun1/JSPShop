package online.luffyk.servlet.home;

import online.luffyk.domain.Category;
import online.luffyk.service.impl.CategoryServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class doProductAddServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doProductAddServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        CategoryServiceImpl categoryService = new CategoryServiceImpl();
        List<Category> categories = categoryService.showAllCategoryService();
        if(categories.size()>0){
            logger.debug("查询所有信息成功");
            req.setAttribute("categories",categories);
            req.getRequestDispatcher("/manage/admin_productadd.jsp").forward(req,resp);
        }else{
            logger.debug("没有获取到所有的信息");
        }

    }
}
