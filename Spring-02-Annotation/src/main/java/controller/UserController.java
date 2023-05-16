package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import service.UserService;

import javax.annotation.Resource;

@Controller
public class UserController {
    //@Resource
    @Autowired
    private UserService userService;
    public void insertOne(){
        userService.insertOne();
    }
    public void showAll(){
        System.out.println(userService.showAll());
    }
}
