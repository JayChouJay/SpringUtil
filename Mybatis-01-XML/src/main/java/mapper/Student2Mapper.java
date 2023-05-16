package mapper;

import domain.nton.Student2;
import org.apache.ibatis.session.SqlSession;
import util.MySqlSessionFactory;

import java.util.List;

public class Student2Mapper {
    private SqlSession session = MySqlSessionFactory.getSqlSession(true);
    public Student2 selectOneBySid(Integer sid){
        return session.selectOne("mapper.Student2Mapper.selectOneBySid",sid);
    }
    public List<Student2> selectAll(){
        return session.selectList("mapper.Student2Mapper.selectAll");
    }
    public List<Student2> selectAll2(){
        return session.selectList("mapper.Student2Mapper.selectAll2");
    }
}
