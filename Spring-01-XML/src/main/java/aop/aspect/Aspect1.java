package aop.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

//切面对象
public class Aspect1 {
    public void beforeMethod() {
        System.out.println("前置建议");
    }

    public void afterMethod() {
        System.out.println("后置建议");
    }

    public void finallyMethod() {
        System.out.println("最终建议");
    }

    public void exception() {
        System.out.println("异常建议");
    }

    public void aroundMethod(ProceedingJoinPoint pjp) {
        System.out.println("环绕建议：前执行");
        try {
            pjp.proceed();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕建议：后执行");
    }
}
