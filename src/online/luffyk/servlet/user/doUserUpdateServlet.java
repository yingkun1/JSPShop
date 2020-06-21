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

public class doUserUpdateServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doUserUpdateServlet.class);
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
        Integer status = 1;
        if(req.getParameter("status")!=null){
            status = Integer.parseInt(req.getParameter("status"));
        }
        logger.debug("status:"+status);
        User user = new User(user_id, username, password, sex, birthday, null, email, mobile, address, status);
        Integer index = userService.updateOneUserService(user);
        if(index > 0){
//          resp.sendRedirect("/JSPShop/manage/admin_user.jsp");
            HttpSession session = req.getSession();
            String count = String.valueOf(session.getAttribute("count"));
            String currentPage = String.valueOf(session.getAttribute("currentPage"));
            logger.debug("count:"+count);
            logger.debug("currentPage:"+currentPage);
            resp.sendRedirect("/JSPShop/admin_douserselect?count="+count+"&currentPage="+currentPage);
        }else{
            resp.sendRedirect("/JSPShop/admin_touserupdate?id="+user_id);
        }
    }
}
