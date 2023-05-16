package controller;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 以xml文件配置的标准Servlet
 */
public class NativeServlet extends HttpServlet {
    //可以写个人的属性
    private int count = 0;

    //对象初始化时执行，像是构造方法
    //应用：判断是否是延时加载Servlet
    public void init() {
    }

    //用来读取配置文件中携带的信息
    public void init(ServletConfig config) {
        //获取请求名字
        String name = config.getServletName();
        //获取上下文的对象（JSP九大内置对象之一）
        ServletContext app = config.getServletContext();

        String results = config.getInitParameter("key1");
        //类似map中的keySet方法
        Enumeration en = config.getInitParameterNames();
        while (en.hasMoreElements()) {
            String key = (String) en.nextElement();
            String value = config.getInitParameter(key);
        }
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
    }

    //重写了doGet或doPost，则不能重写service，
    //建议重写这个方法
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置参数的字符集
        request.setCharacterEncoding("UTF-8");
        //request存值和取值
        //（request有两个map）:Map<String,Object>
        String paramString = request.getParameter("key");
        request.setAttribute("abalance", "value");
        request.getAttribute("abalance");

        //内部转发
        RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
        rd.forward(request, response);
        ThreadLocal<String> local=new ThreadLocal<>();
        local.set("123");
        local.get();

        //设置返回内容的字符集
        response.setCharacterEncoding("UTF-8");
        //重定向
        response.setHeader("Refresh", "xxx.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }

    //对象销毁时执行，类似finalize
    //应用：判断对象释放
    public void destory() {
    }
}
