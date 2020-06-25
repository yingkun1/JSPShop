package online.luffyk.servlet.category;

import online.luffyk.service.CategoryService;
import online.luffyk.service.impl.CategoryServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class doCategoryDeleteServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doCategoryDeleteServlet.class);
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Integer category_id = -1;
        if(req.getParameter("category_id")!=null){
            category_id = Integer.parseInt(req.getParameter("category_id"));
        }
        logger.debug("category_id:"+category_id);
        Integer index = categoryService.deleteOneCategoryByIdService(category_id);
        if(index>0){
            logger.debug("删除成功");
            resp.sendRedirect("/JSPShop/admin_categoryselect");
        }else{
            logger.debug("删除失败");
            resp.sendRedirect("/JSPShop/admin_categoryselect");
        }

    }
}
