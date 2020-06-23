package online.luffyk.servlet.user;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class doUserCaptchaCheckServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doUserCaptchaCheckServlet.class);
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String input_captcha = req.getParameter("captcha");
        HttpSession session = req.getSession();
        String code = (String) session.getAttribute("code");
        logger.debug("用户输入的验证码为："+input_captcha);
        logger.debug("服务器session域中的验证码的值为："+code);
        PrintWriter writer = resp.getWriter();
        if(code.equalsIgnoreCase(input_captcha)){
            writer.print(true);
        }else{
            writer.print(false);
        }
    }
}
