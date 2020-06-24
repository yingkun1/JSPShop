package online.luffyk.service;

import online.luffyk.domain.User;

import java.util.List;

public interface UserService {
     Integer AddOneUserService(User user);

     List<User> showAllUserService(int count,int currentPage,String keywords);

     int[] totalNumsAndPagesService(int count,String keywords);

     User getUserInfoByIdService(String id);

     Integer updateOneUserService(User user);

     Integer deleteOneUserService(String id);

     Integer deleteMoreUserService(String[] ids);

     Boolean checkUserIdExist(String id);

     Integer registerUserService(User user);

     User loginUserService(String id,String password);

     User loginAdminUserService(String id,String password);
}
