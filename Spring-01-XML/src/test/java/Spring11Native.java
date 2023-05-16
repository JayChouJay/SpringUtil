import org.junit.Test;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class Spring11Native {
    ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("spring/spring-11-native.xml");

    /**
     * xml配置工厂，通过方法获得对象
     */
    @Test
    public void factoryObj() {
        Object obj = factory.getBean("objFac");
        System.out.println(obj);
    }

    /**
     * 测试-国际化
     * 测试失败
     */
    @Test
    public void message() {
        MessageSource ms = (MessageSource) factory.getBean("messageSource");

        String name = ms.getMessage("name", null, "def", new Locale("zh", "CN"));

        System.out.println(name);

    }
}
