package test;

import mvc.annotation.Mapper;
import mvc.annotation.Sql;
import mvc.factory.BeanFactory;
import mvc.factory.CommonPath;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by zhuran on 2019/1/14 0014
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String path = Test.class.getClassLoader().getResource("").getPath();
        List<String> list = CommonPath.listClassFileAbsolutePath(path);
        for(String s:list){
            Class clazz = Class.forName(s);
            Mapper mapper = (Mapper) clazz.getAnnotation(Mapper.class);
            if(mapper!=null){
                Method[] methods = clazz.getMethods();
                for(int i=0;i<methods.length;i++){
                    Sql sql = methods[i].getAnnotation(Sql.class);
                    if(sql!=null){
                        System.out.println(sql.getClass());
                        System.out.println(sql.sql());
                        methods[i].invoke(clazz.newInstance(), sql.sql());
                    }
                }
            }
        }
    }
}
