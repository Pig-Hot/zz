package mvc.common.utils;

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

    public static Object map2Object(Map map,Class clazz){
        try {
            Object obj = clazz.newInstance();
            Map<String,String> methodMap = getSetMethod(clazz);
            for(Object object:map.keySet()){
                String methodName = "set" + StringKit.fristCharToLowerCase((String) obj);
                String simpleNmae = methodMap.get(methodName);
                Method method = null;
                if(simpleNmae.equals("String")){
                    method = clazz.getMethod(methodName,String.class);
                    method.invoke(obj,String.valueOf(map.get(obj)));
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
