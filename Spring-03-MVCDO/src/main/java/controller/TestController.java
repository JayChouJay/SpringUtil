package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 相同请求会匹配其他约束
 */
@Controller
public class TestController {
    @RequestMapping("/test.do")
    public String test() {
        System.out.println("0成功了");
        return "index.html";
    }

    @RequestMapping(value = "/test.do", params = {"user=zzt", "pass"})
    public String testOne() {
        System.out.println("1成功了");

        return "index.html";
    }

    @RequestMapping(value = "/test.do", method = RequestMethod.GET)
    public String testTwo() {
        System.out.println("2成功了");
        return "index.html";
    }

    @RequestMapping(value = "/test.do", headers = {"Accept-Language"})
    public String testThree() {
        System.out.println("3成功了");
        return "index.html";
    }
}
