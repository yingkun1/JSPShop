package online.luffyk.servlet.home;

import com.jspsmart.upload.*;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String product_name = req.getParameter("product_name");
        String product_price = req.getParameter("product_price");
        logger.debug("product_name:"+product_name);
        logger.debug("product_price:"+product_price);
//        SmartUpload smartUpload = new SmartUpload();
//        //初始化
//        smartUpload.initialize(this.getServletConfig(),req,resp);
//        try {
//            smartUpload.upload();
//        } catch (SmartUploadException e) {
//            e.printStackTrace();
//        }
//        Files files = smartUpload.getFiles();
//        File file = files.getFile(0);
//        logger.debug("file:"+file);
//        String fileName = file.getFileName();
//        String filePathName = file.getFilePathName();
//        logger.debug("filePathNam:"+filePathName);
//        logger.debug("fileName:"+fileName);
//        try {
//            smartUpload.save("img");
//        } catch (SmartUploadException e) {
//            e.printStackTrace();
//        }
//        String product_name1 = smartUpload.getRequest().getParameter("product_name");
//        String product_price1 = smartUpload.getRequest().getParameter("product_price");
//        logger.debug("product_name1:"+product_name1);
//        logger.debug("product_price1:"+product_price1);
        SmartUpload smartUpload = new SmartUpload();
        smartUpload.initialize(this.getServletConfig(),req,resp);
        try {
            smartUpload.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        Files files = smartUpload.getFiles();
        File file = files.getFile(0);
        logger.debug("fileName:"+file.getFileName());
        logger.debug("filePath:"+file.getFilePathName());
        try {
            smartUpload.save("img");
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        Request request = smartUpload.getRequest();
        String product_name1 = request.getParameter("product_name");
        String product_price1 = request.getParameter("product_price");
        logger.debug("product_name1:"+product_name1);
        logger.debug("product_price1:"+product_price1);

    }
}
