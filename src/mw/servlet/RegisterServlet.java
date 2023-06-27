package mw.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mw.user.UserServers;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        System.out.println(username + " " + password);
        boolean flag = false;
        try {
            flag = UserServers.insertUserInfo(username, password, email);
            System.out.println(flag);
            PrintWriter out = response.getWriter();
            if (flag) {
                out.print("<script language='javascript'>alert('Register Success! Go login!');window.location.href='welcome.jsp';</script>");
            } else {
                out.print("<script language='javascript'>alert('Register Failed! Please retry!');window.location.href='welcome.jsp';</script>");
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }
}