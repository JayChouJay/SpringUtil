package controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;
import java.util.List;

public class UploadController extends HttpServlet {
    //传入解析后的文件对象，以及文件所要保存的地址
    private void nativeUploadToDownload(FileItem item,String filePath) throws IOException {
        //原生：通过输入流读取网络传递过来的文件内容
        InputStream inputStream = item.getInputStream();
        OutputStream outputStream = new FileOutputStream(filePath + item.getName());
        byte[] b = new byte[1024];
        int length = inputStream.read(b);
        while (length != -1) {
            outputStream.write(b, 0, length);
            outputStream.flush();
            length = inputStream.read(b);
        }
        outputStream.close();
    }
    //判断文件是否符合规则
    private boolean testFileType(String fileName){
        String[] box={".txt",".doc",".pdf",".png",".jpg",".md"};
        for (int i = 0; i < box.length; i++) {
            if (fileName.endsWith(box[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //注意：传统手段无法解析req
            //由于提交的form是文件相关的，所以无法正常req.getparam取值
            //Enumeration en1 = req.getParameterNames();
            //while (en1.hasMoreElements()) {
                //System.out.println(en1.nextElement());
            //}
            //传统方法可以无法获取内容
            System.out.println(req.getParameter("testFile"));
            //步骤1.获取factory
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //默认缓冲区是temp文件夹，默认允许大小：10240
            //设置缓冲区大小
            //factory.setSizeThreshold(1024000);
            //设置缓冲区位置
            //factory.setRepository(new File(""));
            ServletFileUpload upload = new ServletFileUpload(factory);
            //设置限制单个文件大小
            //upload.setFileSizeMax(10);
            //设置上传文件的总大小
            //upload.setSizeMax(10);
            //设置文件名字的字符集
            upload.setHeaderEncoding("UTF-8");
            //设置上传监听器
            upload.setProgressListener(new ProgressListener() {
                @Override
                public void update(long l, long l1, int i) {
                    System.out.println("当前是第"+i+"个组件，上传进度:"+((double) l / l1)*100+"%");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            //解析request
            //文件超出设置大小时，在解析req时会出现异常
            List<FileItem> itemList = upload.parseRequest(req);
            for (FileItem item : itemList) {
                if (item.isFormField()) {
                    //如果是组件
                    //获取组件name
                    System.out.println("成功了" + item.getFieldName());
                    //读取组件value
                    System.out.println("成功了" + item.getString());
                    //通过UTF-8编码获取组件的value
                    String value = item.getString("UTF-8");
                } else {
                    //如果是文件
                    //获取组件的name属性
                    String key = item.getFieldName();
                    String fileName = item.getName();
                    //如果文件名符合要求可以返回正常页面
                    if(testFileType(fileName)){
                        //注意：其他盘符可能会找不到位置（需手动创建文件夹），工程目录下可以生成文件夹
                        //item.write(new File("D://sql/" + item.getName()));
                        //获取工程根目录
                        //req.getSession().getServletContext().getRealPath("/");
                        //this.getServletContext().getRealPath("/");

                        String realPath=req.getSession().getServletContext().getRealPath("/");
                        item.write(new File(realPath+"/WEB-INF/classes/sql/" + item.getName()));
                    }else{
                        req.getRequestDispatcher("404.jsp").forward(req,resp);
                    }


                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
