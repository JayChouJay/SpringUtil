package testmvc;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TestDao {
    public void select(){
        System.out.println("查询到了结果");
    }
}
