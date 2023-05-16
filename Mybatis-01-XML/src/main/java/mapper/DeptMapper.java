package mapper;

import domain.oneton.Dept;
import org.apache.ibatis.session.SqlSession;
import util.MySqlSessionFactory;

import java.util.List;

public class DeptMapper {
    private SqlSession session= MySqlSessionFactory.getSqlSession(true);
    public Dept selectOneByDeptno(Integer deptno){
        return session.selectOne("mapper.DeptMapper.selectOneByDeptno",deptno);
    }
    public List<Dept> getAll(){
        return session.selectList("mapper.DeptMapper.getAll");
    }
    public List<Dept> getAll2(){
        return session.selectList("mapper.DeptMapper.getAll2");
    }
}
