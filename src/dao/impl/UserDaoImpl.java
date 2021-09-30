package dao.impl;

import dao.UserDao;
import pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public int findUserId(String username, String password) {
        String sql = "select id from t_user where username = ? and password = ?";
        Object o = querySingleValue(sql, username, password);
        if (o == null) {
            return -1;
        }
        return (Integer) o;
    }

    @Override
    public int addUser(User user) {
        String sql = "insert into t_user(id, username, password, email) values(?,?,?,?)";
        return update(sql, user.getId(), user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public User queryUserById(Integer id) {
        String sql = "select id, username, password, email from t_user where id = ?";
        return queryForOne(User.class, sql, id);
    }

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id, username, password, email from t_user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id, username, password, email from t_user where username = ? and password = ?";
        return queryForOne(User.class, sql, username, password);
    }
}
