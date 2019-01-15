package mvc.factory;

import mvc.annotation.Register;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by zhuran on 2019/1/15 0015
 */
public class ScanRegister {

    public static void init() {
        String path = BeanFactory.class.getClassLoader().getResource("").getPath();
        List<String> list = CommonPath.listClassFileAbsolutePath(path);
        for (String s : list) {
            try {
                Class clazz = Class.forName(s);
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    Register register = field.getAnnotation(Register.class);
                    if (register != null) {
                        Object common = BeanFactory.getCommon(field.getName()).getClass();
                        field.set(BeanFactory.getCommon(clazz.getName()), common);
                    }
                }
            } catch (ClassNotFoundException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
