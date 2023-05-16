package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dept {
    //自有属性
    private Integer deptno;
    private String dname;
    private String loc;
    //为了根据deptno部门编号查询部门中所有的人更加方便
    //也存储一个关联属性 一个部门多个EMP-->List
    private List<Emp> empList;
}
