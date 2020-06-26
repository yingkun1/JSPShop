package online.luffyk.servlet.home;

import com.jspsmart.upload.*;
import online.luffyk.domain.Category;
import online.luffyk.domain.Product;
import online.luffyk.service.ProductService;
import online.luffyk.service.impl.CategoryServiceImpl;
import online.luffyk.service.impl.ProductServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class doProductAddServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doProductAddServlet.class);
    private CategoryServiceImpl categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
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
        SmartUpload smartUpload = new SmartUpload();
        smartUpload.initialize(this.getServletConfig(),req,resp);
        try {
            smartUpload.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        Files files = smartUpload.getFiles();
        File file = files.getFile(0);
        String fileName = file.getFileName();
        logger.debug("fileName:"+fileName);
        logger.debug("filePath:"+file.getFilePathName());
        try {
            smartUpload.save("img/product");
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        Request request = smartUpload.getRequest();
        String product_name = request.getParameter("product_name");
        String parent_id = request.getParameter("parent_id");
        String product_image = request.getParameter("product_image");
        String product_price = request.getParameter("product_price");
        String product_desc = request.getParameter("product_desc");
        String product_stock = request.getParameter("product_stock");
        logger.debug("product_name:"+product_name);
        logger.debug("parent_id:"+parent_id);
        logger.debug("product_image:"+product_image);
        logger.debug("product_price:"+product_price);
        logger.debug("product_desc:"+product_desc);
        logger.debug("product_stock:"+product_stock);
        int twoLevelId = -1;
        int productPrice = -1;
        int productStock = -1;
        if(request.getParameter("parent_id")!=null){
            twoLevelId = Integer.parseInt(request.getParameter("parent_id"));
        }
        if(request.getParameter("product_price")!=null){
            productPrice = Integer.parseInt(request.getParameter("product_price"));
        }
        if(request.getParameter("product_stock")!=null){
            productStock = Integer.parseInt(request.getParameter("product_stock"));
        }
        Category category = categoryService.getCategoryInfoByIdService(twoLevelId);
        Integer oneLevelId = category.getCATEGORY_PARENT_ID();
        logger.debug("oneLevelId:"+oneLevelId);
        logger.debug("twolevelId:"+twoLevelId);
        Product product = new Product(null, product_name, product_desc, productPrice, productStock, oneLevelId, twoLevelId, fileName);
        logger.debug("product:"+product);
        ProductService productService = new ProductServiceImpl();
        Integer index = productService.addOneProductService(product);
        if(index>0){
            logger.debug("插入成功");
            resp.sendRedirect("/JSPShop/admin_productselect");
        }else{
            logger.debug("插入失败");
            resp.sendRedirect("/JSPShop/admin_productadd");
        }
    }
}
