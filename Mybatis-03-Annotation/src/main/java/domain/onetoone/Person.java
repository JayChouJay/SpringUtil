package domain.onetoone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private Integer id;
    private String pname;
    private String cardId;
    private IDCard idCard;
}
