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

/**
 * 返回全部Emp
 */
@WebServlet("/selectAllEmp")
public class SelectAllEmpController extends HttpServlet {
    private EmpService empService = MySpring.getBean("service.EmpService");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Emp> empList = empService.selectAllEmp();
        //通过json响应回浏览器
        JSONObject json = new JSONObject();
        json.put("empList", empList);
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json.toJSONString());
    }
}
