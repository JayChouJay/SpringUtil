package mapper;

import domain.Dept;
import domain.Emp;
import org.apache.ibatis.session.SqlSession;
import util.MySqlSessionFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class EmpMapper {
    private SqlSession session = MySqlSessionFactory.getSqlSession(true);

    public List<Emp> selectAll() {
        return session.selectList("mapper.EmpMapper.getAll");
    }

    public List<Emp> selectByDeptnoAndJob(Map<String, Object> map) {
        return session.selectList("selectByDeptnoAndJob", map);
    }

    public Emp selectOneByEmpno(Integer empno) {
        return session.selectOne("mapper.EmpMapper.selectOneByDeptno", empno);
    }

    public List<Integer> selectAllDeptno() {
        return session.selectList("mapper.EmpMapper.selectAllDeptno");
    }

    public List<String> selectAllJob() {
        return session.selectList("mapper.EmpMapper.selectAllJob");
    }

    public int updateJobByEmpno(List<String> empnos){
        return session.update("updateJobByEmpno",empnos);
    }
}
