package mvc.filter.handle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 处理action
 * Created by zhuran on 2019/1/9 0009
 */
public class ActionHandle {
    public void handle(String method, Class controller, HttpServletRequest request, HttpServletResponse response) {
        try {
            Object o = controller.newInstance();
            controller.getMethod("setRequest",HttpServletRequest.class).invoke(o,request);
            controller.getMethod("setResponse",HttpServletResponse.class).invoke(o,response);
            Method m = controller.getMethod(method,null);
            m.invoke(o,null);
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
