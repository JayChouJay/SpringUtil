import domain.onetoone.Person;
import mapper.PersonMapper;
import org.junit.Test;
import util.MySpring;

import java.util.List;
//通过cardId联合查询IdCard
public class PersonTest {
    PersonMapper mapper = MySpring.getBean("mapper.PersonMapper");

    @Test
    public void getAllOrderBy() {
        List<Person> persons = mapper.getAllOrderBy("desc");
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    @Test
    public void getAll2() {
        List<Person> persons = mapper.getAll2();
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
