package mvc.common;

import mvc.controller.ZZController;
import sun.dc.pr.PRError;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ZZ框架信息库
 * Created by zhuran on 2019/1/9 0009
 */
public class Constant {

    private String encoding = "utf-8";

    //路由信息
    private static Map<String, Class> routeMap = new ConcurrentHashMap<>();

    //Bean信息
    private static Map<String, Object> beanMap = new ConcurrentHashMap<>();

    /*得到一个Controller*/
    public Class getRoute(String route) {
        return routeMap.get(route);
    }

    public Object getBean(String string) {
        return beanMap.get(string);
    }

    public void setBean(String string, Object object) {
        beanMap.put(string, object);
    }

    public static Map<String, Object> getBeanMap() {
        return beanMap;
    }

    public static void setBeanMap(Map<String, Object> beanMap) {
        Constant.beanMap = beanMap;
    }

    /*设置Controller*/
    public void setRoute(String route, Class<? extends ZZController> controller) {
        routeMap.put(route, controller);
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public Map<String, Class> getRouteMap() {
        return routeMap;
    }

    public void setRouteMap(Map<String, Class> routeMap) {
        this.routeMap = routeMap;
    }
}
