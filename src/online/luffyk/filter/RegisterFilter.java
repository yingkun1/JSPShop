package online.luffyk.filter;

import online.luffyk.service.UserService;
import online.luffyk.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterFilter implements Filter {
    private Logger logger = Logger.getLogger(RegisterFilter.class);
    private UserService userService = new UserServiceImpl();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        logger.debug("过滤器拦截到了注册的请求");
        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirm_password = req.getParameter("confirm_password");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");
        String address = req.getParameter("address");
        String input_captcha = req.getParameter("code");
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("code");
        logger.debug("input_captcha:"+input_captcha);
        logger.debug("code:"+code);
        logger.debug("id:"+id);
        logger.debug("username:"+username);
        logger.debug("password:"+password);
        logger.debug("confirm_password:"+confirm_password);
        logger.debug("sex:"+sex);
        logger.debug("birthday:"+birthday);
        logger.debug("email:"+email);
        logger.debug("mobile:"+mobile);
        logger.debug("address:"+address);
        PrintWriter writer = response.getWriter();
        if(id!=null&&!("").equals(id)){
            Boolean idExist = userService.checkUserIdExist(id);
            if(idExist){
                writer.print("用户ID已存在，请通过表单注册");
                response.sendRedirect("/JSPShop/reg.jsp");
                return;
            }
        }else{
            writer.print("用户ID不能为null或为'',请通过表单注册");
            response.sendRedirect("/JSPShop/reg.jsp");
            return;
        }
        if(input_captcha!=null&&!("").equals(input_captcha)){
            if(!input_captcha.equals(code)){
                writer.print("验证码不正确，请通过表单注册");
                response.sendRedirect("/JSPShop/reg.jsp");
                return;
            }
        }else{
            writer.print("验证码不能为null或\"+\"请通过表单注册");
            response.sendRedirect("/JSPShop/reg.jsp");
            return;
        }

        logger.debug("放行了========================================");
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
