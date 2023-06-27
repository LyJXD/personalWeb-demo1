package mw.dao;

import mw.DBUtil;
import mw.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    //登陆查询数据库
    public User selectByName(String name) throws SQLException {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        DBUtil util = new DBUtil();
        User user = new User();
        try {
            conn = util.getConn();
            stmt = conn.prepareStatement("select * from user_info where username = ?");
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt(1));  //第几个字段
                user.setName(rs.getString(2));
                user.setPassword(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.close(conn, stmt, rs);
        }
        return user;
    }

    //注册插入数据库
    public boolean insertUserInfo(String name, String password, String email) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        DBUtil util = new DBUtil();
        boolean flag = true;
        try {
            conn = util.getConn();
            stmt = conn.prepareStatement("insert into user_info(username, password, email) values(?,?,?)");
            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            util.close(conn, stmt, rs);
        }
        return flag;
    }

}
