package mw.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mw.food.foodServers;
import mw.food.home_food;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/FoodServlet")
public class FoodServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 处理get请求
        String id = request.getParameter("id");
        System.out.println("响应了ajax请求");
        System.out.println("id ---> " + id);

        String json = "{}";

        foodServers fs = new foodServers();
        try {
            home_food food = fs.getFood(Integer.parseInt(id));
            //转为Jackson
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(food);
            System.out.println(json);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //返回json格式数据
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();

    }

}
