package mw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    public DBUtil() {
    }

    /**
     * 获取Connection
     */
    public Connection getConn() {
        Connection conn = null;
        try {
            //驱动包位置
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("驱动加载失败");
            e.printStackTrace();
        }
        try {
            //sqlServer连接和数据库名
            String url = "jdbc:sqlserver://localhost;database=个人网站;encrypt=true;trustServerCertificate=true;";
            String user = "sa";//数据库账号
            String pwd = "123456";//数据库密码
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("连接成功");
        return conn;
    }

    /**
     * 关闭资源
     */
    public void close(Connection conn, PreparedStatement st, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}