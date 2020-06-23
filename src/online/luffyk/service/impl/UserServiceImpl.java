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
    public List<User> showAllUserService(int count,int currentPage,String keywords) {
        logger.debug("准备获取所有的用户数据");
        List<User> users = userDao.showAllUserDao(count,currentPage,keywords);
        if(users!=null&&users.size()>0){
            logger.debug("获取到了全部用户的数据");
        }else{
            logger.debug("获取全部用户的数据失败");
        }
        return users;
    }

    @Override
    public int[] totalNumsAndPagesService(int count,String keywords) {
        logger.debug("准备获取总记录数和总页数");
        int[] total = userDao.totalNumsAndPagesDao(count,keywords);
        if(total[0]>0){
            logger.debug("获取到了总记录数:"+total[0]+",和总页数:"+total[1]);
        }else{
            logger.debug("没有获取到总记录数和总页数");
        }
        return total;
    }

    @Override
    public User getUserInfoByIdService(String id) {
        logger.debug("准备根据id:"+id+"获取指定用户的数据");
        User user = userDao.getUserInfoByIdDao(id);
        if(user!=null){
            logger.debug("获取到了用户的数据");
        }else{
            logger.debug("获取用户的数据失败");
        }
        return user;
    }

    @Override
    public Integer updateOneUserService(User user) {
        logger.debug("准备更新一个用户");
        Integer index = userDao.updateOneUserDao(user);
        if(index>0){
            logger.debug("更新成功");
        }else{
            logger.debug("更新失败");
        }
        return index;

    }

    @Override
    public Integer deleteOneUserService(String id) {
        logger.debug("准备删除id为："+id+"的用户");
        Integer index = userDao.deleteOneUserDao(id);
        if(index>0){
            logger.debug("已经删除了该用户");
        }else{
            logger.debug("删除用户失败");
        }
        return index;
    }

    @Override
    public Integer deleteMoreUserService(String[] ids) {
        logger.debug("准备批量删除用户.");
        Integer sum= 0;
        for(String value:ids){
            int index = 0;
            logger.debug("准备删除id为："+value+"的用户");
            index = userDao.deleteOneUserDao(value);
            if(index>0){
                sum++;
                logger.debug("id为："+value+"的用户删除成功");
            }else{
                logger.debug("id为："+value+"的用户删除失败");
            }
        }
        return sum;
    }

    @Override
    public Boolean checkUserIdExist(String id) {
        logger.debug("准备检查该id:"+id+"是否已经被注册过了");
        User user = userDao.getUserInfoByIdDao(id);
        Boolean flag = false;
        if(user!=null){
            logger.debug("该id:"+id+"已经被注册过了");
            flag = true;
        }else{
            logger.debug("该id:"+id+"还没有被注册");

        }
        return flag;

    }

    @Override
    public Integer registerUserService(User user) {
        logger.debug("准备注册新用户");
        Integer index = userDao.AddOneUserDao(user);
        if(index>0){
            logger.debug("用户注册成功，用户名为："+user.getUSER_NAME());
        }else{
            logger.debug("用户注册失败");
        }
        return index;
    }

    @Override
    public User loginUserService(String id, String password) {
        logger.debug("用户："+id+"准备登陆");
        User user = userDao.loginUserDao(id, password);
        if(user!=null){
            logger.debug("用户："+id+"登录成功");
        }else{
            logger.debug("用户："+id+"登录失败");
        }
        return user;
    }

}
