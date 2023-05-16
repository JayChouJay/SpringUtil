package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 介绍简单的html请求处理
 */
@WebServlet(value = {"/test", "/index"},
        loadOnStartup = 0,
        initParams = {@WebInitParam(name = "1", value = "2"),
                @WebInitParam(name = "1", value = "2")})
public class NativeInteractiveServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //0.获取浏览器传递的cookies
        Cookie[] cookies = req.getCookies();
        String name = null;
        String pass = null;
        for (int i = 0; i < cookies.length; i++) {
            //判断获取的cookies

            if (cookies[i].getName().equals("name")) {
                name = cookies[i].getValue();
            }
            if (cookies[i].getName().equals("pass")) {
                pass = cookies[i].getValue();
            }
        }

        //1.获取String类型的数据
        String valString = req.getParameter("key");
        //2.获取checkbox的数组
        String[] valCheckBox = req.getParameterValues("key1");
        for (String val : valCheckBox) {
            if (val.equals("true")) {
                //如果特定的被选中，例如储存7天
            }
        }


        //添加cookie
        Cookie cookie = new Cookie("key", "value");
        //设置存活时间7天
        cookie.setMaxAge(3600 * 24 * 7);
        resp.addCookie(cookie);

    }
}
