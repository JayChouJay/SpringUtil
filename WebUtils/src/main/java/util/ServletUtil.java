package util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class ServletUtil {
    public static void printReq(HttpServletRequest req){
        Enumeration<String> en=req.getParameterNames();
        while (en.hasMoreElements()){
            System.out.println(en.nextElement());
        }
        System.out.println("-----上面是打印Request-----");
    }
}
