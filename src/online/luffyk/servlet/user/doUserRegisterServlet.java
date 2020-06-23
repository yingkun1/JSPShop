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

public class doUserRegisterServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doUserRegisterServlet.class);
    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirm_password = req.getParameter("confirm_password");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String address = req.getParameter("address");
        logger.debug("id:"+id);
        logger.debug("username:"+username);
        logger.debug("password:"+password);
        logger.debug("confirm_password:"+confirm_password);
        logger.debug("sex:"+sex);
        logger.debug("birthday:"+birthday);
        logger.debug("email:"+email);
        logger.debug("mobile:"+mobile);
        logger.debug("address:"+address);
        User user = new User(id, username, password, sex, birthday, null, email, mobile, address, 1);
        Integer index = userService.registerUserService(user);
        if(index>0){
            logger.debug("注册成功");
            resp.sendRedirect("/JSPShop/login.jsp");
        }else{
            logger.debug("注册失败");
            resp.sendRedirect("/JSPShop/reg.jsp");
        }

    }
}
