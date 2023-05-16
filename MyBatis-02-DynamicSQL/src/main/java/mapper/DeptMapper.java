package mapper;

import domain.Dept;
import org.apache.ibatis.session.SqlSession;
import util.MySqlSessionFactory;

import java.util.List;

public class DeptMapper {
    private SqlSession session= MySqlSessionFactory.getSqlSession(true);
    public List<Dept> selectAll(){
        return session.selectList("selectAll");
    }
    public Dept selectOneByDeptno(Integer deptno){
        return session.selectOne("selectOneByDeptno",deptno);
    }
}
