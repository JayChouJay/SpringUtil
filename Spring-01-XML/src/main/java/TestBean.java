import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class TestBean {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("spring/ApplicationContext.xml");

        //国际化测试失败
//        MessageSource ms = (MessageSource) factory.getBean("messageSource");
//        String name = ms.getMessage("name", null, "def", new Locale("zh", "CN"));
//        System.out.println(name);
    }
}
