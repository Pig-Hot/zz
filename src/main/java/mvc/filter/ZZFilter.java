package mvc.filter;

import mvc.common.utils.UrlKit;
import mvc.config.ZZConfig;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 框架主过滤器
 * Created by zhuran on 2019/1/9 0009
 */
public class ZZFilter implements Filter {

    private ZZConfig config = null;

    public void init(FilterConfig filterConfig) throws ServletException {
        //主要用于读取配置文件
        //System.out.println("zz框架初始化");
        String paramName = filterConfig.getInitParameter("initParam");
        try {
            config = (ZZConfig) Class.forName(paramName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (config != null) {
            config.init();
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("zz框架过滤");
        //拦截uri
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        /*设置编码格式*/
        request.setCharacterEncoding(ZZConfig.CONSTANT.getEncoding());
        response.setCharacterEncoding(ZZConfig.CONSTANT.getEncoding());
        response.setContentType("text/html;"+ZZConfig.CONSTANT.getEncoding());
        String result[] = UrlKit.getUriTail(request.getRequestURI(),request.getContextPath());
        //System.out.println("route: " + result[0] + " method: " + result[1]);
        int index = request.getRequestURI().indexOf(".");
        if(index==-1){
            Class controller = ZZConfig.CONSTANT.getRoute(result[0]);
            if(controller==null && !result[0].equals("/")){
                try {
                    throw new RuntimeException("该Controller不存在");
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }else {
                config.getActionHandle().handle(result[1],controller,request,response);
            }
        }else {
            request.getRequestDispatcher("/WEB-INF/views" + result[0]).forward(request,response);
        }
    }

    public void destroy() {
        //销毁
        System.out.println("zz框架被销毁");
    }
}
