package exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 这是一个自定义的异常处理类
 * 我们自己写类，自己定义处理规则
 * 将这个类交给Spring管理
 */
@Component
public class ExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv=new ModelAndView();
        //1.验证以下不活的异常
        if (ex instanceof MyException){
            mv.setViewName("redirect:error.html");
        }else {
            mv.setViewName("welcome.html");
        }
        return mv;
    }
}
