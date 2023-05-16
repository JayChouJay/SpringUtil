package mapper;

import domain.Student;
import domain.Teacher;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TeacherMapper {
    @Select("select * from teacher where tid = #{tid}")
    Teacher selectOne(Integer tid);

    @Insert("insert into teacher values (null, #{param1}, #{param2}, #{param3})")
        //参数可以按照paramn的写法传递
    void insert(String tname, String tsex, Integer tage);

    @Delete("delete from teacher where tid = #{tid}")
        //给参数取别名
    void delete(@Param("tid") Integer sid);

    @Update("update teacher set tname=#{tname},tsex=#{tsex},tage=#{tage} where tid=#{tid}")
    void update(Student student);
}
