package mapper;

import domain.one.T1_Student;
import org.apache.ibatis.session.SqlSession;
import util.MySqlSessionFactory;

import java.util.List;

public class T1StudentMapper {
    private SqlSession session = MySqlSessionFactory.getSqlSession(true);

    //查询所有<学生>，根据ID顺序排列
    public List<T1_Student> getAllOrderBy(String flag) {
        return session.selectList("getAllOrderBy",flag);
    }

}
