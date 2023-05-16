package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 以xml文件配置的标准Request的Listener
 */
public class NativeRequestListener implements ServletRequestListener, ServletRequestAttributeListener {
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request对象销毁了");
    }

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request对象创建了");
    }
    public void attributeAdded(ServletRequestAttributeEvent srae) {
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae) {
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae) {
    }
}
