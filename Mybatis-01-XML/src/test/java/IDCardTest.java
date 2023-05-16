import mapper.IDCardMapper;
import org.junit.Test;
import util.MySpring;
//通过cardID联合查询Person
public class IDCardTest {
    IDCardMapper mapper = MySpring.getBean("mapper.IDCardMapper");

    @Test
    public void getAll(){
        System.out.println(mapper.getAll());
    }

    @Test
    public void getAllOrderBy(){
        System.out.println(mapper.getAllOrderBy("desc"));
    }

    @Test
    public void selectOneByCardId(){
        System.out.println(mapper.selectOneByCardId("830000199001011859"));
    }
}
