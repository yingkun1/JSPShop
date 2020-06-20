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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class doUserAddServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doUserAddServlet.class);
    private UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String user_id = req.getParameter("user_id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirm_password = req.getParameter("confirm_password");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String address = req.getParameter("address");
        logger.debug("user_id:"+user_id);
        logger.debug("username:"+username);
        logger.debug("password:"+password);
        logger.debug("sex:"+sex);
        logger.debug("birthday:"+birthday);
        logger.debug("email:"+email);
        logger.debug("mobile:"+mobile);
        logger.debug("address:"+address);
        User user = new User(user_id, username, password, sex, birthday, null, email, mobile, address, 1);
        Integer index = userService.AddOneUserService(user);
        if(index>0){
            resp.sendRedirect("/JSPShop/admin_douserselect?count=10&currentPage=1");
        }else{
            logger.debug("插入信息失败了，重新跳转到插入页面");
            resp.sendRedirect("/JSPShop/manage/admin_userAdd.jsp");
        }

    }
}
