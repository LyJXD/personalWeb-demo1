import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.sql.DriverManager.getConnection;

public class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.out.println("加载驱动成功！");
        //2.连接
        String dbURL = "jdbc:sqlserver://localhost;database=个人网站;encrypt=true;trustServerCertificate=true;";//DatabaseName=跟上要连接的数据库名称，我要连接db1数据库，所以DatabaseName=db1
        String user = "sa";
        String password = "123456";//在引号中修改为自己设置的登陆密码
        Connection conn = getConnection(dbURL, user, password);
        System.out.println("连接数据库成功！");
        //3.定义SQL语句
        String sql = "select * from home_attraction";
        //4.获取执行SQL对象并执行
        PreparedStatement stmt = conn.prepareStatement(sql);
        //5.处理结果
        ResultSet res = stmt.executeQuery();
        while (res.next()) {
            String title = res.getString("name");
            System.out.println(title);
        }
        //6.释放资源
        stmt.close();
        conn.close();

    }
}