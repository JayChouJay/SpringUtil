package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Bean01Simple {
    private Integer id;
    private String sname;
    private String spass;
    public void init(){
        System.out.println(sname+"被初始化啦");
    }
    public void finalize(){
        System.out.println(sname+"被销毁啦");
    }
}
