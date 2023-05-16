package controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class TestController {


    @RequestMapping("/index")
    public void index(HttpServletRequest request, HttpServletResponse response) {
        Cookie testCookie = new Cookie("1", "2");
        testCookie.setMaxAge(60);
        response.addCookie(testCookie);

//        try {
//            System.out.println(request.getParameter("testFile"));
//            DiskFileItemFactory factory = new DiskFileItemFactory();
//            ServletFileUpload upload = new ServletFileUpload(factory);
//            List<FileItem> itemList = upload.parseRequest(request);
//            System.out.println("-----连上了2222-------555---");
//            for (FileItem item : itemList) {
//                if (item.isFormField()) {
//                    System.out.println("成功了" + item.getFieldName());
//                    System.out.println("成功了" + item.getName());
//                } else {
//                    System.out.println("失败了");
//                }
//            }
//        } catch (FileUploadException e) {
//            e.printStackTrace();
//        }
    }
}
