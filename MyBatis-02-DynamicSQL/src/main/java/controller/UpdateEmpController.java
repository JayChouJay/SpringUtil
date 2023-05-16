package controller;

import service.EmpService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 通过Empno更改Emp的job
 */
@WebServlet("/updateEmpByEmpno")
public class UpdateEmpController extends HttpServlet {
    private EmpService empService = MySpring.getBean("service.EmpService");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] empnos = req.getParameterValues("empno");
//        for (String empno:empnos){
//            System.out.println(empno);
//        }
        //更新
        empService.updateJobByEmpno(empnos);
        req.getRequestDispatcher("update.html").forward(req, resp);

    }
}
