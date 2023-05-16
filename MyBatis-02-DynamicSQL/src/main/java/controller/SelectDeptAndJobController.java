package controller;

import com.alibaba.fastjson.JSONObject;
import service.EmpService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectDeptnoAndJob")
public class SelectDeptAndJobController extends HttpServlet {
    private EmpService empService = MySpring.getBean("service.EmpService");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //控制层的查询deptno和job
        List<Integer> deptnoList = empService.selectAllDeptno();
        List<String> jobList = empService.selectAllJob();
        //通过json响应回浏览器
        JSONObject json = new JSONObject();
        json.put("deptnoList", deptnoList);
        json.put("jobList", jobList);
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json.toJSONString());
    }
}
