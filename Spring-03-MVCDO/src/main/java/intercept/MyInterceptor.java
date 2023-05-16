package intercept;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 我们自定义的拦截器
 * 可以继承HandlerInterceptorAdapter
 * 也可以实现HandlerInterceptor
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    /**
     * PreHandle:预处理（controller之前执行）
     * PostHandle：请求后处理（controller之后执行）
     * afterCompletion：完成后处理（controller执行完毕后执行）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("资源执行之前执行");
        request.getRequestDispatcher("welcome.html").forward(request, response);
        //        System.out.println("还是可以执行了");
        //true放行，false不放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("资源执行之后执行");
    }
    //可以处理异常
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("最终执行");
    }
}
