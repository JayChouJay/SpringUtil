import domain.oneton.Emp;
import mapper.EmpMapper;
import org.junit.Test;
import util.MySpring;

import java.util.List;

public class EmpTest {
    EmpMapper empMapper= MySpring.getBean("mapper.EmpMapper");
    @Test
    public void selectOneByEmpno(){
        System.out.println(empMapper.selectOneByEmpno(7369));
    }
    @Test
    public void getAll(){
        List<Emp> emps=empMapper.getAll();
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }

}
