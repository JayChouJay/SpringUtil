import domain.one.Student;
import mapper.StudentMapper;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class StudentTest {
    StudentMapper studentMapper = new StudentMapper();

    //查学生个数
    @Test
    public void selectCount() {
        System.out.println("总共：--" + studentMapper.selectCount() + "---个学生");
    }

    //查询一个学生的姓名
    @Test
    public void selectOneNameById() {
        System.out.println(studentMapper.selectOneNameById(3));
    }
    //查询所有学生
    @Test
    public void getAllOrderBy() {
        List<Student> students= studentMapper.getAllOrderBy("desc");
        for (Student student:students)
        System.out.println(student);
    }
    //查询所有学生Map
    @Test
    public void getAllMap() {
        List<Map<String, Object>> result = studentMapper.getAllMap();
        for (Map<String, Object> map : result)
            System.out.println(map);
    }
    //插入一个学生
    @Test
    public void insertOne() {
        studentMapper.insertOne(new Student(null, "周杰伦", "123", 41, "男",null));
    }
    //通过id改学生性别--map
    @Test
    public void updateOneByMap(){
        studentMapper.updateOneSex(3,"nan");
    }
    //通过id改学生性别--对象
    @Test
    public void updateOneByStudent(){
        studentMapper.updateOneSex(new Student(3,null,null,null,"男",null));
    }
}
