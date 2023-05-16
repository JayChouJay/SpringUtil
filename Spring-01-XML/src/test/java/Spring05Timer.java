import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring-Context-Support的Task
 * 依赖包：quartz,tx,slf4j-api
 */
public class Spring05Timer {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("spring/spring-05-timer.xml");

    }
}
