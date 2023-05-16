package controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 上传和下载Controller
 * SpringMVC内置文件解析器，我们导入包后，使用mvc的内置对象
 */
@Controller
public class UADController {
    @RequestMapping("/upload")
    public String upload(String text, MultipartFile upload) throws IOException {
        System.out.println(text);
        //文件名字
        String fileName = upload.getOriginalFilename();
        //文件对象
        upload.transferTo(new File("D://test//", fileName));
        return "welcome.html";
    }


    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(String fileName) throws IOException {
        ResponseEntity<byte[]> entity;
        File file = new File("D://test//" + fileName);
        //处理文件名中文
        fileName= new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentDispositionFormData("attachment", fileName);
        //将响应信息存入一个返回值对象内即可
        byte[] b = FileUtils.readFileToByteArray(file);
        entity = new ResponseEntity<byte[]>(b, httpHeaders, HttpStatus.CREATED);
        return entity;
    }


}
