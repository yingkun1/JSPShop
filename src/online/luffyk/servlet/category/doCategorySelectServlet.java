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
        int count = 10;
        int currentPage = 1;
        String keywords = "";
        if(req.getParameter("count")!=null&&!("").equals(req.getParameter("count"))){
            count = Integer.parseInt(req.getParameter("count"));
        }
        if(req.getParameter("currentPage")!=null&&!("").equals(req.getParameter("currentPage"))){
            currentPage = Integer.parseInt(req.getParameter("currentPage"));
        }
        keywords = req.getParameter("keywords");
        logger.debug("count===="+count);
        logger.debug("currentPage===="+currentPage);
        List<Category> categories = categoryService.showAllCategoryService(count,currentPage,keywords);
        for(Category category:categories){
            logger.debug(category);
        }
        int[] numsAndPages = categoryService.totalNumsAndPagesService(count,keywords);
        int totalNums = numsAndPages[0];
        int totalPages = numsAndPages[1];
        logger.debug("totalNums:"+totalNums);
        logger.debug("totalPagesNums:"+totalPages);
        if(categories.size()>0){
            if(keywords!=null && !keywords.equals("")){
                req.setAttribute("keywords","&keywords="+keywords);
            }
            req.setAttribute("count",count);
            req.setAttribute("currentPage",currentPage);
            req.setAttribute("totalNums",totalNums);
            req.setAttribute("totalPagesNums",totalPages);
            req.setAttribute("categories",categories);
            req.getRequestDispatcher("/manage/admin_category.jsp").forward(req,resp);
        }else{
            logger.debug("获取分类失败");
            req.setAttribute("categories",categories);
            req.getRequestDispatcher("/manage/admin_category.jsp").forward(req,resp);
        }
    }
}
