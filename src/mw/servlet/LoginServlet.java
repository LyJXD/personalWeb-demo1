package mw.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mw.user.User;
import mw.user.UserServers;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet(value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取登录的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = null;
        try {
            user = UserServers.selectByName(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert user != null;
        PrintWriter out = response.getWriter();
        if (password.equals(user.getPassword())) {
            out.print("<script language='javascript'>alert('Login Success!');window.location.href='home.jsp';</script>");
        } else {
            out.print("<script language='javascript'>alert('Login Failed!');window.location.href='welcome.jsp';</script>");
        }
        out.flush();
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }
}
