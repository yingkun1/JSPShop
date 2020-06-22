package online.luffyk.servlet.user;

import online.luffyk.service.UserService;
import online.luffyk.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

public class doUserDeleteServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private Logger logger = Logger.getLogger(doUserUpdateServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String[] parameterValues = request.getParameterValues("id[]");
        HttpSession session = request.getSession();
        String count = String.valueOf(session.getAttribute("count"));
        String currentPage = String.valueOf(session.getAttribute("currentPage"));
        if(parameterValues!=null){
            Integer sum = userService.deleteMoreUserService(parameterValues);
            logger.debug("sum:"+sum);
            logger.debug("parameterValue.length"+parameterValues.length);
            if(sum==parameterValues.length){
                response.sendRedirect("/JSPShop/admin_douserselect?count="+count+"&currentPage="+currentPage);
            }else{
                logger.debug("没有删除完选中的用户,存在管理员用户");
                response.sendRedirect("/JSPShop/admin_douserselect?count="+count+"&currentPage="+currentPage);
            }
        }else{
            logger.debug("没有完选中用户");
            response.sendRedirect("/JSPShop/admin_douserselect?count="+count+"&currentPage="+currentPage);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        String count = String.valueOf(session.getAttribute("count"));
        String currentPage = String.valueOf(session.getAttribute("currentPage"));
        Integer index = userService.deleteOneUserService(id);
        if(index>0){
            response.sendRedirect("/JSPShop/admin_douserselect?count="+count+"&currentPage="+currentPage);
        }else{
            logger.debug("删除失败");
            response.sendRedirect("/JSPShop/admin_douserselect?count="+count+"&currentPage="+currentPage);
        }

    }
}
