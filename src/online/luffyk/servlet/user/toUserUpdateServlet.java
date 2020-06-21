package online.luffyk.servlet.user;

import online.luffyk.domain.User;
import online.luffyk.service.UserService;
import online.luffyk.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class toUserUpdateServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(toUserUpdateServlet.class);
    private  UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
        logger.debug("id:"+id);
        User user = userService.getUserInfoByIdService(id);
        logger.debug("根据id:"+id+"获取的用户数据为:"+user);
        req.setAttribute("user",user);
        req.getRequestDispatcher("/manage/admin_usermodify.jsp").forward(req,resp);
    }
}
