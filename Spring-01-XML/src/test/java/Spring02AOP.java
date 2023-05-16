import aop.controller.TestController;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring02AOP {
    BeanFactory factory = new ClassPathXmlApplicationContext("spring/spring-02-aop.xml");

    @Test
    public void aop() {
        TestController controller = (TestController) factory.getBean("controller");
        controller.test();
    }
}
