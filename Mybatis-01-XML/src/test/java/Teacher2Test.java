import domain.nton.Teacher2;
import mapper.Teacher2Mapper;
import org.junit.Test;
import util.MySpring;

import java.util.List;

public class Teacher2Test {
    Teacher2Mapper mapper= MySpring.getBean("mapper.Teacher2Mapper");
    //查询全部-两条语句
    @Test
    public void selectAll(){
        List<Teacher2> teacher2List = mapper.selectAll();
        for (Teacher2 teacher2 : teacher2List) {
            System.out.println(teacher2);
        }
    }
    //查询全部-内连接
    @Test
    public void selectAll2(){
        List<Teacher2> teacher2List = mapper.selectAll2();
        for (Teacher2 teacher2 : teacher2List) {
            System.out.println(teacher2);
        }
    }
    //查询一个
    @Test
    public void selectOne(){
        System.out.println(mapper.selectOneByTid(2));
    }
}
