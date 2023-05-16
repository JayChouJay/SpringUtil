package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
//保证能够懒加载返回Json
@JsonIgnoreProperties(value = {"handler"})
public class Emp implements Serializable {
    private Integer empno;
    private String ename;
    private Integer sal;
    private Integer deptno;
    //关联属性 deptno-->外键-->对象
    private Dept dept;
}
