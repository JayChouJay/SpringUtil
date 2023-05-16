package listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 自定义监听器
 */
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        //事件的回调方法
        System.out.println("接收到的事件:\t" + event.toString());
        if (event instanceof MyApplicationEvent) {
            MyApplicationEvent myEvent = (MyApplicationEvent) event;
            System.out.println("用户：\t" + myEvent.getUsername());
            System.out.println("邮箱：\t" + myEvent.getEmail());
        }

    }
}
