package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class InnerController {

    @RequestMapping("/header.do")
    public String session(@RequestHeader("Accept-Language") String header, @CookieValue("JSESSIONID")String cookieValue) {
        System.out.println("测试协议头");
        System.out.println("接收到的参数：" + header);
        System.out.println("接收到的Cookie-JSESSIONID" + cookieValue);
        return "index.html";
    }
    /**
     * @RequestBody注解（JSON）接收json，放在参数前面,只能接收Post请求
     * @ResponseBody
     *
     * @return
     */
    @RequestMapping("/testReqBody.do")
    public String test(@RequestBody String body, String sex) {
        System.out.println("body:"+body);
        System.out.println("pass:"+sex);
        return "index.html";
    }

    /**
     * @param body
     * @ModelAttribute注解，放在某一个方法上面，在请求方法执行之前执行
     *
     * @return
     */
    @ModelAttribute("/testReqBody.do")
    public String test(@RequestBody String body){
        return "null";
    }
}
