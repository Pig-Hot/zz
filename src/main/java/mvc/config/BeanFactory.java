package mvc.config;

/**
 * Created by zhuran on 2019/1/14 0014
 */
public class BeanFactory {
    public Object createSimpleBean(Class clazz) {
        Object obj = null;
        try {
            obj = clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
}
