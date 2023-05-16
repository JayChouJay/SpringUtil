import domain.onetoone.Person;
import mapper.PersonMapper;
import org.junit.Test;
import service.PersonService;
import util.MySpring;

import java.util.List;

//通过cardId联合查询IdCard
public class PersonTest {
    PersonService personService = MySpring.getBean("service.PersonService");

    @Test
    public void getAll() {
        List<Person> persons = personService.selectAll();
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    @Test
    public void getAll2() {
        List<Person> persons = personService.selectAll();
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    @Test
    public void selectOneById() {
        Person person = personService.selectOne(2);
        System.out.println(person);
    }
}
