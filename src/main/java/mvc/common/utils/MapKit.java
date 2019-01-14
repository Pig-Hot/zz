package mvc.common.utils;

import mvc.modle.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuran on 2019/1/11 0011
 */
public class MapKit {

    public static Map<String, String> getSetMethod(Class clazz) {
        Method[] methods = clazz.getMethods();
        Map<String, String> map = new HashMap<String, String>();
        try {
            Object obj = clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("set")) {
                map.put(methodName, method.getParameterTypes()[0].getSimpleName());
            }
        }
        return map;
    }

    public static Object map2Object(Map map, Class clazz) {
        Object obj = null;
        try {
            obj = clazz.newInstance();
            Map<String, String> methodMap = getSetMethod(clazz);
            for (Object object : map.keySet()) {
                String methodName = "set" + StringKit.fristCharToLowerCase((String) object);
                String simpleNmae = methodMap.get(methodName);
                Method method = null;
                switch (simpleNmae) {
                    case "String":
                        method = clazz.getMethod(methodName, String.class);
                        method.invoke(obj, String.valueOf(map.get(object)));
                        break;
                    case "int":
                        method = clazz.getMethod(methodName, int.class);
                        method.invoke(obj, (Integer) map.get(object));
                        break;
                    case "Integer":
                        method = clazz.getMethod(methodName, Integer.class);
                        method.invoke(obj, (Integer) map.get(object));
                        break;
                    case "double":
                        method = clazz.getMethod(methodName, double.class);
                        method.invoke(obj, (Double) map.get(object));
                        break;
                    case "long":
                        method = clazz.getMethod(methodName, long.class);
                        method.invoke(obj, (Long) map.get(object));
                        break;
                    case "float":
                        method = clazz.getMethod(methodName, float.class);
                        method.invoke(obj, (Float) map.get(object));
                        break;
                    case "boolean":
                        method = clazz.getMethod(methodName, boolean.class);
                        method.invoke(obj, (Boolean) map.get(obj));
                        break;
                    case "Float":
                        method = clazz.getMethod(methodName, Float.class);
                        method.invoke(obj, (Float) map.get(object));
                        break;
                    case "Long":
                        method = clazz.getMethod(methodName, Long.class);
                        method.invoke(obj, (Long) map.get(object));
                        break;
                    case "Double":
                        method = clazz.getMethod(methodName, Double.class);
                        method.invoke(obj, (Double) map.get(object));
                        break;
                }
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
