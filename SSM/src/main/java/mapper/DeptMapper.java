package mapper;

import domain.Dept;

import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface DeptMapper {

    @Insert("insert into dept value(null,#{dname},#{loc})")
        //插入成功后返回主键
    @Options(useGeneratedKeys = true, keyProperty = "deptno")
    void insert(Dept dept);

    @Select("select * from dept")
    @Results(
            {
                    @Result(property = "deptno",column = "deptno"),
                    @Result(property = "empList",column = "deptno",many = @Many(select = "mapper.EmpMapper.findByDeptno"))
            }
    )
    List<Dept> findAll();
}
