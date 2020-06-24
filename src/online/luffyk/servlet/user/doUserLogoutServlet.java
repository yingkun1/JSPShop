package online.luffyk.servlet.user;

import online.luffyk.domain.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class doUserLogoutServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doUserLogoutServlet.class);
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("用户点击了退出按钮");
        HttpSession session = req.getSession();
        logger.debug("用户："+((User)session.getAttribute("user")).getUSER_NAME()+"准备退出");
        session.invalidate();
        logger.debug("用户退出成功");
        resp.sendRedirect("/JSPShop/login.jsp");
    }
}
