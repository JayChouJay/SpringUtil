package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class ResponseController {
    //原生的响应
    @RequestMapping("/testResponse.do")
    public void response(String username, String pass, HttpServletResponse response) {
        System.out.println("通过response返回信息");
        System.out.println(username + "----" + pass);
        try {
            //设置响应字符集
            //          response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.write("你好hello");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //原生的转发
    public void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("welcome.html").forward(request,response);
    }

    //原生的重定向
    public void sendRedirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("welcome.html");
    }

    //1SpringMVC的转发
    @RequestMapping("/forward.do")
    public String forward() {
        //默认就是转发
        //""会转到欢迎页，“null”找null资源，null报404
        //return "forward:welcome.html";
        return "welcome.html";
    }



    //2SpringMVC的重定向
    @RequestMapping("/sendRedirect.do")
    public String sendRedirect() {

        return "redirect:welcome.html";
    }
}
