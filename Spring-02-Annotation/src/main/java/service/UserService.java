package service;

import mapper.UserDao;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public void insertOne(){
        userDao.insert();
    }
    public List<User>showAll(){
        return userDao.selectAll();
    }
}
