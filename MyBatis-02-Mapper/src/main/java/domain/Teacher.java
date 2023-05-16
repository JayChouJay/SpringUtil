package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {
    //自有属性
    private Integer tid;
    private String tname;
    private String tsex;
    private Integer tage;
}
