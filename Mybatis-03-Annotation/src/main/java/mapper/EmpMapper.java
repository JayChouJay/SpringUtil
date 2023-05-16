package mapper;

import domain.oneton.Emp;
import org.apache.ibatis.session.SqlSession;
import util.MySqlSessionFactory;

import java.util.List;

public class EmpMapper {
    private SqlSession session= MySqlSessionFactory.getSqlSession(true);
    public Emp selectOneByEmpno(Integer empno){
        return session.selectOne("mapper.EmpMapper.selectOneByEmpno",empno);
    }
    public List<Emp> getAll(){
        return session.selectList("mapper.EmpMapper.getAll");
    }
}
