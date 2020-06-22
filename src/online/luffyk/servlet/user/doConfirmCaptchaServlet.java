package online.luffyk.servlet.user;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class doConfirmCaptchaServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doConfirmCaptchaServlet.class);
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String input_code = req.getParameter("code");
        logger.debug("用户输入的验证码为:"+input_code);
        HttpSession session = req.getSession();
        String generateCode = (String) session.getAttribute("code");
        logger.debug("后台生成的验证码为:"+generateCode);
        if(generateCode.equalsIgnoreCase(input_code)){
            logger.debug("验证码输入正确");
        }else{
            logger.debug("验证码输入错误");
        }
    }
}
