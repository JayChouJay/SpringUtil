package controller;

import jdk.internal.util.xml.impl.Input;
import org.apache.commons.fileupload.FileUploadBase;
import util.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;

/**
 * 下载文件
 * 当前只能下载指定文件
 */
public class DownloadController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //打印request
        ServletUtil.printReq(req);
        String fileName = req.getParameter("fileName");
        //打印文件名
        System.out.println(fileName);
        //指定位置找文件
        InputStream inputStream = new FileInputStream("D://sql/" + fileName);
        //InputStream inputStream=Thread.currentThread().getContextClassLoader().getResourceAsStream("WEB-INF/classes/sql/"+fileName);
        //resp.setCharacterEncoding("UTF-8");

        //如果名字含有中文
        //%E8%81%94%E5%8C%96%E5%AE%89%E5%85%A8%E6%89%8B%E5%86%8C.md
        fileName = URLEncoder.encode(fileName, "UTF-8");
        //设置解析方式：弹出进度条
        resp.setContentType("application/x-msdownload");
        //设置下载时的文件名
        resp.setHeader("Content-disposition", "attachment;filename=" + fileName);
        System.out.println(fileName);
        //将内容写回浏览器
        OutputStream outputStream = resp.getOutputStream();
        byte[] bytes = new byte[1024];
        int length = inputStream.read(bytes);
        while (length != -1) {
            outputStream.write(bytes, 0, length);
            outputStream.flush();
            length = inputStream.read(bytes);
        }
    }
}
