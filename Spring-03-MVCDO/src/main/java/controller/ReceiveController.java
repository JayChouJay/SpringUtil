package controller;

import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

@Controller
public class ReceiveController {
    //接收普通参数
    @RequestMapping("/receiveParams.do")
    public String param(String username, Integer pass,Date birthday) {
        System.out.println("1接收到普通参数");
        System.out.println("用户名:" + username);
        System.out.println("密码:" + pass);
        System.out.println("生日："+birthday);
        return "index.html";
    }
    //接收普通参数-Date
    //无法转成sql包下的date
    @RequestMapping("/receiveParamsDate.do")
    public String param(java.sql.Date birthday) {
        System.out.println("1接收到普通参数-生日");
        System.out.println("生日："+birthday);
        return "index.html";
    }
    //参数名不相同时用@RequestParam注解指定
    @PostMapping("/receiveParamsAnnotation.do")
    public String paramAnnotation(@RequestParam("username") String use, Integer pass) {
        System.out.println("1参数与方法参数名不同");
        System.out.println("用户名:" + use);
        System.out.println("密码:" + pass);
        return "index.html";
    }
    //参数名不相同时用@RequestParam注解指定
    @PostMapping("/receiveObject.do")
    public String object(User user) {
        System.out.println("2用对象包裹参数");
        System.out.println(user);
        return "index.html";
    }
    //参数名不相同时用@RequestParam注解指定
    @PostMapping("/receiveObjectAndObj.do")
    public String objectAndObj(User user) {
        System.out.println("2用对象包裹参数-套对象");
        System.out.println(user);
        return "index.html";
    }

    @PostMapping("/receiveObjectAndList.do")
    public String objectAndList(User user) {
        System.out.println("2用对象包裹参数-套list");
        System.out.println(user);
        return "index.html";
    }
    //使用map必须加注解
    @PostMapping("/receiveMap.do")
    public String map(@RequestParam Map map) {
        System.out.println("3用map接收所有参数");
        System.out.println(map);
        return "index.html";
    }
    //使用map必须加注解
    @PostMapping("/receiveRequest.do")
    public String request(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("4直接用request");
        request.getSession();
        System.out.println(request.getParameterNames());
        return "index.html";
    }
}
