package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import org.junit.Test;
import pojo.User;

import static org.junit.Assert.*;

public class UserDaoTest {

    private UserDao userDao = new UserDaoImpl();

    @Test
    public void addUser() {
        System.out.println(userDao.addUser(new User(null, "admin", "admin", "admin@qq.com")));
    }

    @Test
    public void queryUserById() {
        System.out.println(userDao.queryUserById(2));
    }

    @Test
    public void queryUserByUsername() {
        System.out.println(userDao.queryUserByUsername("admin"));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        System.out.println(userDao.queryUserByUsernameAndPassword("admin", "admin"));
    }
}