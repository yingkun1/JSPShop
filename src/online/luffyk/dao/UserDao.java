package online.luffyk.dao;

import online.luffyk.domain.User;

import java.util.List;

public interface UserDao {

    Integer AddOneUserDao(User user);

    List<User> showAllUserDao(int count,int currentPage,String keywords);

    int[] totalNumsAndPagesDao(int count,String keywords);

    User getUserInfoByIdDao(String id);

    Integer updateOneUserDao(User user);

    Integer deleteOneUserDao(String id);

    User loginUserDao(String id,String password);
}
