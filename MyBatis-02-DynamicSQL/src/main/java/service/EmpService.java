package service;

import domain.Emp;
import mapper.DeptMapper;
import mapper.EmpMapper;
import util.MySpring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EmpService {
    private EmpMapper empMapper = MySpring.getBean("mapper.EmpMapper");

    public List<Emp> selectAllEmp() {
        return empMapper.selectAll();
    }

    public List<Integer> selectAllDeptno() {
        return empMapper.selectAllDeptno();
    }

    public List<String> selectAllJob() {
        return empMapper.selectAllJob();
    }

    public List<Emp> selectByDeptnoAndJob(String deptno, String job, String orderFlag) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("deptno", deptno);
        map.put("job", job);
        map.put("orderFlag", orderFlag);
        return empMapper.selectByDeptnoAndJob(map);
    }

    public int updateJobByEmpno(String[] empnos) {

        return empMapper.updateJobByEmpno(Arrays.asList(empnos));
    }
}
