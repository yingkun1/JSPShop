package online.luffyk.service;

import online.luffyk.domain.User;

import java.util.List;

public interface UserService {
     Integer AddOneUserService(User user);

     List<User> showAllUserService(int count,int currentPage);

     int[] totalNumsAndPagesService(int count);
}
