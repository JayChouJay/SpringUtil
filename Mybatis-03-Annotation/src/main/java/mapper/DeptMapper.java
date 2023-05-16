package mapper;

import domain.oneton.Dept;
import domain.oneton.Emp;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;


import java.util.List;

public interface DeptMapper {
    @Results(id = "selectOne",
            value = {
                    @Result(property = "deptno", column = "deptno"),
                    @Result(property = "empList", javaType = List.class, column = "deptno", many = @Many(select = "selectEmpList", fetchType = FetchType.LAZY))
            })
    @Select("select * from dept where deptno=#{deptno}")
    public Dept selectOneByDeptno(Integer deptno);

    @Select("select * from dept")
    @ResultMap("selectOne")
    public List<Dept> getAll();

    @Results(id = "selectOne2",
            value = {
                    @Result(property = "deptno", column = "deptno"),
                    @Result(property = "empList", javaType = Emp.class, column = "deptno", many = @Many(select = "selectEmpList"))
            })
    @Select("select empno, ename, sal, emp.deptno, dname, loc from dept left join emp on dept.deptno = emp.deptno")
    public List<Dept> getAll2();

    @Select("select * from emp where deptno=#{deptno}")
    List<Emp> selectEmpList(Integer deptno);
}
