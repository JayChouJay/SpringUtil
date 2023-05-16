package domain.oneton;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Emp {
    private Integer empno;
    private String ename;
    private Float sal;
    //关联属性 deptno-->外键-->对象
    private Dept dept;
}
