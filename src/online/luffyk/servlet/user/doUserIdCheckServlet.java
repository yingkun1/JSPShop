package online.luffyk.servlet.user;

import online.luffyk.service.UserService;
import online.luffyk.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class doUserIdCheckServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doUserIdCheckServlet.class);
    private  UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
        logger.debug("id:"+id);
        Boolean flag = userService.checkUserIdExist(id);
        PrintWriter writer = resp.getWriter();
        writer.print(flag);
    }
}
