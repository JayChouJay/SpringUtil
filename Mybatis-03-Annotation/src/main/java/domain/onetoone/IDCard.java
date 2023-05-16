package domain.onetoone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IDCard {
    private Integer id;
    private String cardId;
    private String address;
    //为了能按照cardId查人
    private Person person;
}
