package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public int findUserId(String username, String password) {
        return userDao.findUserId(username, password);
    }

    @Override
    public int login(String username, String password) {

        User user = userDao.queryUserByUsernameAndPassword(username, password);

        if (user != null) {
            return 1;
        } else {
            return -1;
        }

    }

    @Override
    public void register(User user) {

        userDao.addUser(user);

    }

    @Override
    public boolean isUsernameExists(String username) {

        User user = userDao.queryUserByUsername(username);

        if (user != null) {
            return true;
        }

        return false;

    }
}
