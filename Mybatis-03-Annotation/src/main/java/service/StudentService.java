package service;

import domain.Student;
import mapper.StudentMapper;
import util.MySqlSessionFactory;

import java.util.List;

public class StudentService {
    private StudentMapper studentMapper = MySqlSessionFactory.getSqlSession(true).getMapper(StudentMapper.class);

    //新增学生
    public void insertStudent(Student student) {
        studentMapper.insert(student);
    }

    //删除学生
    public void deleteStudent(Integer sid) {
        studentMapper.delete(sid);
    }

    //修改学生
    public void updateStudent(Student student) {
        studentMapper.update(student);
    }

    //查询一个
    public Student selectOne(Integer sid) {
        return studentMapper.selectOne(sid);
    }

    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }
}
