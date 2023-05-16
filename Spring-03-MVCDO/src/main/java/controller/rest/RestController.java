package controller.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestController {
    @RequestMapping("/testRest.do")
    public String test() {
        System.out.println("0成功了");
        return "index.html";
    }
}
