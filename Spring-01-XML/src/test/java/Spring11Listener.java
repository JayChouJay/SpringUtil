import listener.MyApplicationEvent;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring11Listener {
    ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("spring/spring-12-listener.xml");

    /**
     *
     */
    @Test
    public void processor(){
        MyApplicationEvent event=new MyApplicationEvent("事件内容","周杰伦","10qq.com");
        factory.publishEvent(event);
    }

}
