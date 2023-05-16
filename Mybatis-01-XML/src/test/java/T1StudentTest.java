
import domain.one.T1_Student;
import mapper.T1StudentMapper;
import org.junit.Test;
import util.MySpring;

import java.util.List;

public class T1StudentTest {
    T1StudentMapper studentMapper = MySpring.getBean("mapper.T1StudentMapper");

    //查询所有学生
    @Test
    public void getAllOrderBy() {
        List<T1_Student> students= studentMapper.getAllOrderBy("desc");
        for (T1_Student student:students)
            System.out.println(student);
    }
}
