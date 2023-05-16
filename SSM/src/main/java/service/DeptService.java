package service;

import domain.Dept;
import domain.Emp;
import mapper.DeptMapper;
import mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    //事务，要么都成功
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public void save(String dname, String loc, String[] ename, Integer[] sal) {
        Dept dept = new Dept(null, dname, loc, null);
        deptMapper.insert(dept);
        for (int i = 0; i < ename.length; i++) {
            Emp emp = new Emp(null, ename[i], sal[i], dept.getDeptno(), null);
            empMapper.insert(emp);
        }
    }
    public List<Dept>findAll(){
        return deptMapper.findAll();
    }
}
