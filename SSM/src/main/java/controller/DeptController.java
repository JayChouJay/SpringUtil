package controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import domain.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DeptService;

import java.util.Arrays;
import java.util.List;

@Controller
public class DeptController {
    @Autowired
    private DeptService deptService;

    //配置produces能返回utf-8的字符
    @PostMapping(value = "saveDept", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String saveDept(String dname, String loc, String[] ename, Integer[] sal) {
        System.out.println(dname + "," + loc);
        System.out.println(Arrays.toString(ename));
        System.out.println(Arrays.toString(sal));
        deptService.save(dname, loc, ename, sal);
        return "保存成功";
    }

    @PostMapping("deptList")
    @ResponseBody
    public List<Dept> deptList() {
        System.out.println(deptService.findAll());
        return deptService.findAll();
    }
}
