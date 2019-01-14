package mvc.controller;

import mvc.common.utils.MapKit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuran on 2019/1/9 0009
 */
public class ZZController {
    /**
    * 过滤器创建Controller注入属性
    */
    private HttpServletRequest request;
    private HttpServletResponse response;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    /*返回一个字符串*/
    public void renderString(String context){
        try {
            response.getWriter().write(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*返回一个页面*/
    public void render(String path){
        try {
            request.getRequestDispatcher(path).forward(getRequest(),getResponse());
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*重定向*/
    public void redirect(String actionName){
        try {
            response.sendRedirect(actionName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String,String> getMap(){
        Map<String, String[]> map = request.getParameterMap();
        Map<String,String> _map = new HashMap<>();
        for (String s:map.keySet()){
            String[] v = map.get(s);
            _map.put(s,v[0]);
        }
        return _map;
    }

    public Object getObject(Class clazz){
        return MapKit.map2Object(getMap(),clazz);
    }
}
