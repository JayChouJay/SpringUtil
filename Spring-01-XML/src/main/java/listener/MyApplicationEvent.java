package listener;

import lombok.Data;
import org.springframework.context.ApplicationEvent;
@Data
public class MyApplicationEvent extends ApplicationEvent {
    String username;
    String email;

    public MyApplicationEvent(Object source) {
        super(source);
    }

    public MyApplicationEvent(Object source, String username, String email) {
        super(source);
        this.username = username;
        this.email = email;
    }
}
