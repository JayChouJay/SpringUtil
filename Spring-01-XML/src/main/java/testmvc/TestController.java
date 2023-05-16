package testmvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestController {
    private TestService service;
    public void controller(){
        service.service();
    }
}
