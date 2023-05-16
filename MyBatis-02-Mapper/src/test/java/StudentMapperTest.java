import domain.Student;
import org.junit.Test;
import service.StudentService;
import util.MySpring;

import javax.xml.ws.Service;

public class StudentMapperTest {
    private StudentService service = MySpring.getBean("service.StudentService");

    @Test
    public void insert() {
        Student student = new Student(null, "小兰", "女", 17);
        service.insertStudent(student);
    }
    @Test
    public void delete(){
        service.deleteStudent(5);
    }
    @Test
    public void update(){
        Student student = new Student(6, "小兰", "女", 17);
        service.updateStudent(student);
    }
    @Test
    public void selectOne(){
        System.out.println(service.selectOne(3));
    }
}
