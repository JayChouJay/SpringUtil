package mapper;

import domain.onetoone.IDCard;
import domain.onetoone.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PersonMapper {
    @Select("select * from t2_person")
    @Results(
            id = "selectOne",
            value = {
                    @Result(property = "cardId", column = "cardid"),
                    @Result(property = "idCard", javaType = IDCard.class, column = "cardid", one = @One(select = "SelectOneIDCard"))
            }
    )
    public List<Person> getAll();
    @Results(
            id = "selectOne2",
            value = {
                    @Result(property = "cardId", column = "cardid"),
                    @Result(property = "idCard.id",column = "cid"),
                    @Result(property = "idCard.cardid",column = "cardid"),
                    @Result(property = "idCard.address",column = "address"),
            }
    )
    @Select("select *,c.id cid,p.id pid from t2_person p inner join t2_idcard c on p.cardid = c.cardid")
    public List<Person> getAll2();

    @Select("select * from t2_person where id=#{id}")
    @ResultMap("selectOne")
    public Person selectOneById(Integer id);

    @Select("select * from t2_person order by ${flag}")
    public List<Person> getAllOrderBy(String flag);

    @Select("select * from t2_idcard where cardid=#{cardid}")
    IDCard SelectOneIDCard(String cardid);
}
