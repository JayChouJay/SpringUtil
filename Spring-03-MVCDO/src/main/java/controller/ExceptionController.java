package controller;

import exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 异常处理
 */
@Controller
public class ExceptionController {
    @RequestMapping("/exception.do")
    public String exception() {
        try{
            String s = null;
            s.length();
        }catch (Exception e){
            throw new MyException("服务端业务产生问题啦");
        }

        return "welcome.html";
    }
}
