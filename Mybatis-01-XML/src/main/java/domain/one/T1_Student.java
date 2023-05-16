package domain.one;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
//本类为了测试是否能省略 resultType="domain.T1Student"
//结果：XML中补鞥省略
public class T1_Student {
    private Integer id;
    private String sname;
    private String spass;
    private Integer sage;
    private String ssex;
    private Date birth;
}
