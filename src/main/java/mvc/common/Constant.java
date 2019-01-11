package mvc.common;

import mvc.controller.ZZController;
import sun.dc.pr.PRError;

import java.util.HashMap;
import java.util.Map;

/**
 * ZZ框架信息库
 * Created by zhuran on 2019/1/9 0009
 */
public class Constant {

    private String encoding = "utf-8";

    //路由信息
    private Map<String, Class> routeMap = new HashMap<String, Class>();

    /*得到一个Controller*/
    public Class getRoute(String route) {
        return routeMap.get(route);
    }

    /*设置Controller*/
    public void setRoute(String route, Class<? extends ZZController>  controller) {
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
