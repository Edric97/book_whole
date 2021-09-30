package service;

import pojo.User;

public interface UserService {
    int findUserId(String username, String password);

    int login(String username, String password);//登录成功，返回1；登录失败，返回-1

    void register(User user);

    boolean isUsernameExists(String username);//返回true，说明存在该用户名；否则不存在
}
