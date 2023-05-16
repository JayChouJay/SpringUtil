package service;

import domain.Student;
import domain.Teacher;
import mapper.StudentMapper;
import mapper.TeacherMapper;
import util.MySqlSessionFactory;

public class TeacherService {
    private TeacherMapper teacherMapper = MySqlSessionFactory.getSqlSession(true).getMapper(TeacherMapper.class);

    //查询一个
    public Teacher selectOne(Integer tid){
        return teacherMapper.selectOne(tid);
    }
}
