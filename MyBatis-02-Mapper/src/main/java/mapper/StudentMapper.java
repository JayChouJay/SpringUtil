package mapper;

import domain.Student;

public interface StudentMapper {
    void insert(Student student);

    void delete(Integer sid);

    void update(Student student);

    Student selectOne(Integer sid);
}
