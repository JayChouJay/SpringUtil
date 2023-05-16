package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    //自有属性
    private Integer sid;
    private String sname;
    private String ssex;
    private Integer sage;
}
