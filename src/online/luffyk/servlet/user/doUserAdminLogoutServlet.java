package online.luffyk.servlet.user;

import online.luffyk.domain.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class doUserAdminLogoutServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doUserAdminLogoutServlet.class);
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        User adminUser = (User) session.getAttribute("adminUser");
        logger.debug("管理员用户:"+adminUser.getUSER_NAME()+"准备退出");
        session.invalidate();
        logger.debug("管理员用户退出成功");
        resp.sendRedirect("/JSPShop/manage/admin_login.jsp");
    }
}
