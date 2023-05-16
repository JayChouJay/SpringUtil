package domain.one;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    private Integer id;
    private String sname;
    private String spass;
    private Integer sage;
    private String ssex;
    private Date birth;
}
