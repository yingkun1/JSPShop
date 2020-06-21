package online.luffyk.servlet.user;

import online.luffyk.domain.User;
import online.luffyk.service.UserService;
import online.luffyk.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class doUserSelectServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private Logger logger = Logger.getLogger(doUserAddServlet.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int count = 10;
        int currentPage = 1;
        if(req.getParameter("count")!=null && req.getParameter("currentPage")!=null){
            count = Integer.parseInt(req.getParameter("count"));
            currentPage = Integer.parseInt(req.getParameter("currentPage"));
        }

        String keywords = req.getParameter("keywords");

        logger.debug("keywords:"+keywords);
        int[] total = userService.totalNumsAndPagesService(count,keywords);
        int totalNums = total[0]; //返回的记录总数
        int totalPagesNums = total[1]; //返回的页面总数
        List<User> users = userService.showAllUserService(count,currentPage,keywords);
        if(users!=null&&users.size()>0){
            req.setAttribute("users",users);
            req.setAttribute("totalNums",totalNums);
            req.setAttribute("totalPagesNums",totalPagesNums);
            req.setAttribute("currentPage",currentPage);
            if(keywords!=null && !keywords.equals("")){
                req.setAttribute("keywords","&keywords="+keywords);
            }
            req.getRequestDispatcher("/manage/admin_user.jsp").forward(req,resp);
        }
    }


}
