package mapper;

import domain.onetoone.Person;
import org.apache.ibatis.session.SqlSession;

import util.MySqlSessionFactory;

import java.util.List;

public class PersonMapper {
    private SqlSession session = MySqlSessionFactory.getSqlSession(true);

    public List<Person> getAll() {
        return session.selectList("getAll");
    }
    public List<Person> getAll2() {
        return session.selectList("getAll2");
    }

    public Person selectOneById(Integer id) {
        return session.selectOne("selectOneById",id);
    }
    public List<Person> getAllOrderBy(String flag){
        return session.selectList("getAllOrderBy",flag);
    }
}
