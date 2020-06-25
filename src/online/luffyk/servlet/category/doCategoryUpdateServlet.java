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

public class doCategoryUpdateServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doCategoryUpdateServlet.class);
    private CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Integer category_id = -1;
        Integer parent_id = -1;
        if(req.getParameter("category_id")!=null){
            category_id = Integer.parseInt(req.getParameter("category_id"));
        }
        if(req.getParameter("parent_id")!=null){
            parent_id = Integer.parseInt(req.getParameter("parent_id"));
        }
        String category_name = req.getParameter("category_name");
        logger.debug("category_id:"+category_id);
        logger.debug("category_name:"+category_name);
        logger.debug("parent_id:"+parent_id);
        Category category = new Category(category_id, category_name, parent_id);
        Integer index = categoryService.updateOneCategoryService(category);
        if(index>0){
            logger.debug("更新成功");
            resp.sendRedirect("/JSPShop/admin_categoryselect");
        }else{
            logger.debug("更新失败");
            resp.sendRedirect("admin_tocategoryupdate?category_id="+category_id);
        }
    }
}
