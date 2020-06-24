package online.luffyk.servlet.user;

import online.luffyk.domain.User;
import online.luffyk.service.UserService;
import online.luffyk.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class doAdminUseLoginrServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doAdminUseLoginrServlet.class);
    private UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        logger.debug("id:"+id);
        logger.debug("password:"+password);
        User adminUser = userService.loginAdminUserService(id, password);
        if(adminUser!=null){
            HttpSession session = req.getSession();
            session.setAttribute("adminUser",adminUser);
            session.setAttribute("user",adminUser);
            resp.sendRedirect("/JSPShop/manage/admin_index.jsp");
        }else{
            logger.debug("登录失败");
            req.setAttribute("admin_flag",false);
            req.getRequestDispatcher("/manage/admin_login.jsp").forward(req,resp);
        }

    }
}
