package mapper;

import domain.nton.Student2;
import domain.nton.Teacher2;
import org.apache.ibatis.session.SqlSession;
import util.MySqlSessionFactory;

import java.util.List;

public class Teacher2Mapper {
    private SqlSession session = MySqlSessionFactory.getSqlSession(true);

    public Teacher2 selectOneByTid(Integer tid) {
        return session.selectOne("mapper.Teacher2Mapper.selectOneByTid", tid);
    }

    public List<Teacher2> selectAll() {
        return session.selectList("mapper.Teacher2Mapper.selectAll");
    }
    public List<Teacher2> selectAll2() {
        return session.selectList("mapper.Teacher2Mapper.selectAll2");
    }
}
