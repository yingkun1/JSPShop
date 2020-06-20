package online.luffyk.service.impl;

import online.luffyk.dao.UserDao;
import online.luffyk.dao.impl.UserDaoImpl;
import online.luffyk.domain.User;
import online.luffyk.service.UserService;
import org.apache.log4j.Logger;

import java.util.List;


public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    private Logger logger = Logger.getLogger(UserServiceImpl.class);
    @Override
    public Integer AddOneUserService(User user) {
        logger.debug("准备插入数据");
        Integer index = userDao.AddOneUserDao(user);
        if(index>0){
            logger.debug("插入成功");
        }else{
            logger.debug("插入失败");
        }
        return index;
    }

    @Override
    public List<User> showAllUserService(int count,int currentPage) {
        logger.debug("准备获取所有的用户数据");
        List<User> users = userDao.showAllUserDao(count,currentPage);
        if(users!=null&&users.size()>0){
            logger.debug("获取到了全部用户的数据");
        }else{
            logger.debug("获取全部用户的数据失败");
        }
        return users;
    }

    @Override
    public int[] totalNumsAndPagesService(int count) {
        logger.debug("准备获取总记录数和总页数");
        int[] total = userDao.totalNumsAndPagesDao(count);
        if(total[0]>0){
            logger.debug("获取到了总记录数:"+total[0]+",和总页数:"+total[1]);
        }else{
            logger.debug("没有获取到总记录数和总页数");
        }
        return total;
    }
}
