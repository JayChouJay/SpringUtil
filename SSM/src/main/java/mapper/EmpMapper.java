package mapper;

import domain.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper
public interface EmpMapper {
    @Insert("insert into emp(ename,sal,deptno) value(#{ename},#{sal},#{deptno})")
    void insert(Emp emp);
    @Select("select * from emp where deptno=#{deptno}")
    List<Emp> findByDeptno(Integer deptno);
}
