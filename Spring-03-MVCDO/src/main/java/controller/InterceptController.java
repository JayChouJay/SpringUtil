package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InterceptController {
    @RequestMapping("/intercept.do")
    @ResponseBody
    public String intercept() {
        return "intercept true";
    }
}
