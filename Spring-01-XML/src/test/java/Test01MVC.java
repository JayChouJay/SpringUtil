import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import testmvc.TestController;

public class Test01MVC {
    BeanFactory factory = new ClassPathXmlApplicationContext("spring/spring-testMV.xml");

    @Test
    public void test() {
        TestController controller = (TestController) factory.getBean("testController");
        controller.controller();
    }
}
