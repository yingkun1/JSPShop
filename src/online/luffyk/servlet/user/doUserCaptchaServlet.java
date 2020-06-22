package online.luffyk.servlet.user;

import online.luffyk.util.CodeUtil;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

public class doUserCaptchaServlet extends HttpServlet {
    private Logger logger = Logger.getLogger(doUserCaptchaServlet.class);
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, Object> codeAndPic = CodeUtil.generateCodeAndPic();
        String code = codeAndPic.get("code").toString();
        RenderedImage codePic = (RenderedImage) codeAndPic.get("codePic");
        logger.debug("code:"+code);
        logger.debug("codePic:"+codePic);
        HttpSession session = req.getSession();
        //将验证码的codec存放到session中
        session.setAttribute("code",code);
        //禁止使用缓存
        resp.setHeader("Pragma","no-cache");
        resp.setHeader("Cache-Control","no-cache");
        resp.setDateHeader("Expires",-1);
        resp.setContentType("image/jpeg");
        //通过流，将图片输出到浏览器上
        ServletOutputStream outputStream = resp.getOutputStream();
        ImageIO.write(codePic,"jpeg",outputStream);
        outputStream.close();


    }
}
