package controller;

import com.alibaba.fastjson.JSONObject;
import domain.Emp;
import service.EmpService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectEmp")
public class SelectEmpController extends HttpServlet {
    private EmpService empService = MySpring.getBean("service.EmpService");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptno = req.getParameter("deptno");
        String job = req.getParameter("job");
        String orderFlag = req.getParameter("orderFlag");
        //测试接收到的deptno和job
        //System.out.println("--->"+deptno+"<--->"+job+"<---");

        List<Emp>empList=empService.selectByDeptnoAndJob(deptno,job,orderFlag);
        //通过json响应回浏览器
        JSONObject json = new JSONObject();
        json.put("empList", empList);
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json.toJSONString());
    }
}
