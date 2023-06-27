package mw.user;

import mw.dao.UserDao;

import java.sql.SQLException;

public class UserServers {
    static UserDao userDao = new UserDao();

    public static User selectByName(String name) throws SQLException {
        return userDao.selectByName(name);
    }

    public static boolean insertUserInfo(String name, String password, String email) throws SQLException, ClassNotFoundException {
        return userDao.insertUserInfo(name, password, email);
    }
}
