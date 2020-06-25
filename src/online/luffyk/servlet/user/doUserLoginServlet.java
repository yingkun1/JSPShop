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

public class doUserLoginServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doUserLoginServlet.class);
    private UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        logger.debug("username:"+id);
        logger.debug("password:"+password);
        User user = userService.loginUserService(id, password);
        logger.debug(user);
        if(user!=null){
            logger.debug("登录成功");
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect("/JSPShop/indexservlet");
        }else{
            logger.debug("登录失败");
            req.setAttribute("flag",false);
            req.getRequestDispatcher("/admin_login.jsp").forward(req,resp);
        }
    }
}
