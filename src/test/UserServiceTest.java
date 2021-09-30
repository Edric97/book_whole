package test;

import org.junit.Test;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import static org.junit.Assert.*;

public class UserServiceTest {

    private UserService userService = new UserServiceImpl();

    @Test
    public void login() {
        System.out.println(userService.login("admin", "admin"));
    }

    @Test
    public void register() {
        User user = new User(null, "admin2", "admin2", "admin2@qq.com");
        userService.register(user);
    }

    @Test
    public void isUsernameExists() {
        System.out.println(userService.isUsernameExists("admin2"));
    }
}