package filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 以xml文件配置的标准Filter
 */
public class NativeFilter extends HttpFilter {
    Logger logger= LoggerFactory.getLogger(HttpFilter.class);
    //初始化
    @Override
    public void init(FilterConfig config) throws ServletException {
        super.init();
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        logger.debug("我是Filter");
        String aname=(String) req.getSession().getAttribute("aname");
        String URI=req.getRequestURI();
        logger.debug("我是URI:"+URI);
        if (URI.contains("index")||URI.contains("login")){
            //放行
            chain.doFilter(req,res);
        }else {
            if (aname!=null){
                chain.doFilter(req,res);
            }else {
                req.setAttribute("result","登录已超时");
                req.getRequestDispatcher("index.jsp").forward(req,res);
                logger.debug("我又执行啦");
            }
        }
    }

    //销毁
    @Override
    public void destroy() {
        super.destroy();
    }
}
