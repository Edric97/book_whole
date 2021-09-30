package dao;

import pojo.User;

public interface UserDao {
    int addUser(User user);
    User queryUserById(Integer id);
    User queryUserByUsername(String username);
    User queryUserByUsernameAndPassword(String username, String password);

    int findUserId(String username, String password);
}
