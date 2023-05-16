import domain.Student;
import org.junit.Test;
import service.StudentService;
import service.TeacherService;
import util.MySpring;

public class TeacherMapperTest {
    private TeacherService service = MySpring.getBean("service.TeacherService");

    @Test
    public void selectOne(){
        System.out.println(service.selectOne(3));
    }
}
