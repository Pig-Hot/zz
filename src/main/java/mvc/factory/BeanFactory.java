package mvc.factory;

import mvc.annotation.Bean;
import mvc.annotation.Controller;
import mvc.annotation.Mapper;
import mvc.annotation.Sql;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhuran on 2019/1/15 0015
 */
public class BeanFactory {

    //ALL信息
    private static Map<String, Object> beanFactoryMap = new ConcurrentHashMap<>();

    //路由信息
    private static Map<String, Object> routeMap = new ConcurrentHashMap<>();

    //Bean信息
    private static Map<String, Object> beanMap = new ConcurrentHashMap<>();

    //DB信息
    private static Map<String, String> sqlMap = new ConcurrentHashMap<>();

    //controller信息
    private static Map<String, Object> controllerMap = new ConcurrentHashMap<>();

    public static Object getRoute(String route) {
        return routeMap.get(route);
    }

    public static Object getBean(String bean) {
        return beanMap.get(bean);
    }

    public static Object getSql(String sql) {
        return sqlMap.get(sql);
    }

    public static Object getCommon(String common) {
        return beanFactoryMap.get(common);
    }

    public static void init() {
        //拿到classes
        String path = BeanFactory.class.getClassLoader().getResource("").getPath();
        List<String> list = CommonPath.listClassFileAbsolutePath(path);
        for (String str : list) {
            try {
                Class clazz = Class.forName(str);
                if (clazz != null) {
                    Controller controller = (Controller) clazz.getAnnotation(Controller.class);
                    Bean bean = (Bean) clazz.getAnnotation(Bean.class);
                    Mapper mapper = (Mapper) clazz.getAnnotation(Mapper.class);
                    if (mapper != null) {
                        Method[] methods = clazz.getMethods();
                        for (int i = 0; i < methods.length; i++) {
                            Sql sql = methods[i].getAnnotation(Sql.class);
                            if (sql != null) {
                                sqlMap.put(methods[i].getName(), sql.sql());
                            }
                        }
                    }
                    if (controller != null) {
                        Object o = clazz.newInstance();
                        controllerMap.put(controller.name(), o);
                        routeMap.put(controller.path(), o);
                    }
                    if (bean != null) {
                        beanMap.put(bean.name(), clazz.newInstance());
                    }
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        beanFactoryMap.putAll(sqlMap);
        beanFactoryMap.putAll(controllerMap);
        beanFactoryMap.putAll(beanMap);
    }


}
