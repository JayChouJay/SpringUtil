package domain.nton;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student2 {
    //自有属性
    private Integer id;
    private Integer sid;
    private String sname;
    private String ssex;
    private Integer sage;
    //关联属性：老师集合
    private List<Teacher2> teacher2List;
}
