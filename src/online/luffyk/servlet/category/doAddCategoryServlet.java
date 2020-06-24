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

public class doAddCategoryServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doAddCategoryServlet.class);
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        List<Category> categories = categoryService.showAllCategoryService();
        if(categories.size()>0){
            logger.debug("获取到了所有的用户");
            req.setAttribute("categories",categories);
        }else{
            logger.debug("没有获取到用户");
        }
        req.getRequestDispatcher("/manage/admin_categoryadd.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int parent_id = -1;
        if(req.getParameter("parent_id")!=null){
            parent_id = Integer.parseInt(req.getParameter("parent_id"));
        }
        String category_name = req.getParameter("category_name");
        logger.debug("parent_id:"+parent_id);
        logger.debug("category_name:"+category_name);
        Integer index = categoryService.addOneCategoryService(category_name, parent_id);
        if(index>0){
            logger.debug("插入分类成功");
        }else{
            logger.debug("插入分类失败");
        }
    }
}
