import domain.nton.Student2;
import domain.one.Student;
import mapper.Student2Mapper;
import org.junit.Test;
import util.MySpring;

import java.util.List;

public class Student2Test {
    Student2Mapper mapper= MySpring.getBean("mapper.Student2Mapper");

    @Test
    public void selectAll(){
        List<Student2> student2List= mapper.selectAll();
        for (Student2 student2 : student2List) {
            System.out.println(student2);
        }
    }
    @Test
    public void selectAll2(){
        List<Student2> student2List= mapper.selectAll2();
        for (Student2 student2 : student2List) {
            System.out.println(student2);
        }
    }
    @Test
    public void selectOne(){
        System.out.println(mapper.selectOneBySid(2));
    }
}
