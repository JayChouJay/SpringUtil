package controller;

import domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @RestController相当于在普通方法上面加上@ResponseBody
 * 需要依赖jackson(core,databind,annotation)包
 */
@RestController
public class ResponseBodyController {
    @RequestMapping("/ajax.do")
    public String ajax(){
        return "hello";
    }
    @RequestMapping("/ajaxChinese.do")
    public String ajaxChinese(){
        return "你好";
    }

    @RequestMapping("/ajaxObj.do")
    public Student ajaxObj(){
        Student student=new Student(1L,"周杰伦","123");
        return student;
    }

    /**
     * @RequestBody能接收并解析Json的请求参数
     */
    @RequestMapping("/ajaxObjTwo.do")
    public Student ajaxObjTwo(@RequestBody Student student){
        System.out.println("ajax接收json成功："+student);
        return student;
    }
    @RequestMapping("/ajaxMap.do")
    public Map ajaxMap(){
        HashMap<String,String> map=new HashMap<>();
        map.put("1","夹子");
        map.put("2","夹子");
        map.put("3","夹子");
        map.put("4","夹子");
        return map;
    }
    @RequestMapping("/ajaxList.do")
    public List ajaxList(){
        List list=new ArrayList();
        list.add(new Student(1L,"周杰伦","123"));
        list.add(new Student(2L,"邓紫棋","123"));
        list.add(new Student(3L,"张国荣","123"));
        return list;
    }
    @RequestMapping("/ajaxMapObj.do")
    public Map ajaxMapObj(){
        HashMap<String,Student> map=new HashMap<>();
        map.put("1",new Student(1L,"周杰伦","123"));
        map.put("2",new Student(2L,"周杰伦","123"));
        map.put("1",new Student(3L,"周杰伦","123"));
        return map;
    }
}
