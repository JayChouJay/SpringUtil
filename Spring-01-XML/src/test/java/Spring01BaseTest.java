import domain.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Enumeration;
import java.util.Properties;

public class Spring01BaseTest {
    ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("spring/spring-01-native.xml","spring/spring-03-ref.xml");

    /**
     * 工厂常用方法
     */
    @Test
    public void commons(){
        //关闭spring
        factory.close();
    }

    /**
     * 测试-简单对象
     */
    @Test
    public void simple() {
        Bean01Simple simple = (Bean01Simple) factory.getBean("simple");
        System.out.println(simple);
    }

    /**
     * 测试-对象包含对象
     */
    @Test
    public void includeObject() {
        Bean02Contain contain = (Bean02Contain) factory.getBean("contain");
        System.out.println(contain.getObj1().getName());
    }

    /**
     * 测试-集合对象
     */
    @Test
    public void collection() {
        Bean03Collection collection = (Bean03Collection) factory.getBean("collection");

        //对Properties对象的赋值
        Properties pro = collection.getProperties();

        Enumeration en = pro.propertyNames();
        while (en.hasMoreElements()) {
            String key = (String) en.nextElement();
            System.out.println(pro.get(key));
        }

        //布尔类型也能赋值
        if (collection.getSex()) {
            //lombok重写了toString方法
            System.out.println(collection.toString());
        }
    }

    /**
     * 测试-引入properties
     */
    @Test
    public void springRef() {
        Bean02Object computer = (Bean02Object) factory.getBean("objRef");
        System.out.println(computer.getName());
    }

    /**
     * 测试-SpringEL
     */
    @Test
    public void el() {
        SpringEL el = (SpringEL) factory.getBean("el");
        System.out.println(el.toString());
    }
}
