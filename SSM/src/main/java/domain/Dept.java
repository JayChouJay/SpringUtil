package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(value = {"handler"})
public class Dept implements Serializable {
    //自有属性
    private Integer deptno;
    private String dname;
    private String loc;
    //为了根据deptno部门编号查询部门中所有的人更加方便
    //也存储一个关联属性 一个部门多个EMP-->List
    private List<Emp> empList;
}
