package mapper;

import domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Insert("insert into student values (null, #{sname}, #{ssex}, #{sage})")
    void insert(Student student);

    @Delete("delete from student where sid = #{sid}")
    void delete(Integer sid);

    @Update("update student set sname=#{sname},ssex=#{ssex},sage=#{sage} where sid=#{sid}")
    void update(Student student);

    @Select("select * from student where sid = #{sid}")
    Student selectOne(Integer sid);

    @Select("select * from student")
    List<Student> selectAll();
}
