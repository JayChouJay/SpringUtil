package service;

import domain.Dept;
import mapper.DeptMapper;
import util.MySpring;

import java.util.List;

public class DeptService {
    private DeptMapper mapper= MySpring.getBean("mapper.DeptMapper");
//    public List<Integer> selectAllDeptno(){
//        mapper.selectAll();
//    }
//    public List<String> selectAllJob(){
//        mapper.selectAll();
//    }
}
