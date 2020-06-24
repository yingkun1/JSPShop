package online.luffyk.filter;

import online.luffyk.domain.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    private Logger logger = Logger.getLogger(AdminFilter.class);
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        logger.debug("匹配到了/manage/*开头的请求路径");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String servletPath = request.getServletPath();
        String[] split = servletPath.split("/");
        if(split[2].contains("admin_")){
            if(split[2].contains("admin_login.jsp")){
                chain.doFilter(request,response);
            }
            else{
                HttpSession session = request.getSession();
                User adminUser = (User) session.getAttribute("adminUser");
                if(adminUser!=null){
                    chain.doFilter(request,response);
                    logger.debug("servlet处理完毕");
                }else{
                    logger.debug("由于用户没有登录，是不能访问这些页面的");
                    req.setAttribute("permissionDenied",false);
                    req.getRequestDispatcher("/manage/admin_login.jsp");
                }
            }
        }else{
            chain.doFilter(request,response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
