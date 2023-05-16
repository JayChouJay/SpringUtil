package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
    private String id;
    private String username;
    private String pass;
    private String sex;
    private Date birthday;
    private Wallet wallet;
    private List<Wallet> list;
}
