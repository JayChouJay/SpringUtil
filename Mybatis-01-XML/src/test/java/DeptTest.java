import domain.oneton.Dept;
import mapper.DeptMapper;
import org.junit.Test;
import util.MySpring;

import java.util.List;

public class DeptTest {
    DeptMapper deptMapper = MySpring.getBean("mapper.DeptMapper");

    @Test
    public void selectOneByDeptno() {
        System.out.println(deptMapper.selectOneByDeptno(20));
    }

    @Test
    public void getAll() {
        List<Dept> deptList = deptMapper.getAll();
        for (Dept dept : deptList) {
            System.out.println(dept);
        }
    }

    @Test
    public void getAll2() {
        List<Dept> deptList = deptMapper.getAll2();
        for (Dept dept : deptList) {
            System.out.println(dept);
        }
    }
}
