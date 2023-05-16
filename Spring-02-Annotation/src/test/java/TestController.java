import config.MainConfig;
import controller.UserController;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestController {
    BeanFactory factory = new AnnotationConfigApplicationContext(MainConfig.class);
    JdbcTemplate jdbcTemplate = (JdbcTemplate) factory.getBean("jdbcTemplate");

    @Test
    //展示所有用户
    public void showAll() {
        UserController userController = (UserController) factory.getBean("userController");
        userController.showAll();
    }
}
