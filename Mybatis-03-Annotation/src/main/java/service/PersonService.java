package service;

import domain.onetoone.Person;
import mapper.PersonMapper;
import util.MySqlSessionFactory;

import java.util.List;

public class PersonService {
    private PersonMapper personMapper = MySqlSessionFactory.getSqlSession(true).getMapper(PersonMapper.class);

    //查询一个
    public Person selectOne(Integer id) {
        return personMapper.selectOneById(id);
    }

    public List<Person> selectAll() {
        return personMapper.getAll();
    }
}
