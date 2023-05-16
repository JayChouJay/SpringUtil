package testmvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestService {

    private TestDao dao;
    public void service(){
        dao.select();
    }
}
