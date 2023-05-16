package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bean03Collection {
    private String name;
    private Integer age;
    private Boolean sex;
    private Bean02Object obj;
    private Integer[] array;
    private Bean02Object[] objs;
    private List<Integer> arrayList;
    private Set<Bean02Object> objSet;
    private Map<String, Bean02Object>objMap;
    private Properties properties;

}
