package online.luffyk.servlet.user;

import online.luffyk.service.UserService;
import online.luffyk.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class doUserDeleteServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doUserUpdateServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        logger.debug("删除的用户的id为："+id);
        UserService userService = new UserServiceImpl();
        Integer index = userService.deleteOneUserService(id);
        if(index>0){
            response.sendRedirect("/JSPShop/admin_douserselect");
        }

    }
}
