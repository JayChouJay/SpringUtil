package domain.nton;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher2 {
    //自有属性
    private Integer id;
    private Integer tid;
    private String tname;
    private String tsex;
    private Integer tage;
    //关联属性：学生集合
    private List<Student2> student2List;
}
