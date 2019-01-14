package mvc.filter.handle;

import mvc.annotation.Aop;
import mvc.common.Constant;
import mvc.config.ZZConfig;
import mvc.controller.ZZController;
import mvc.filter.ZZInterceptor;

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
            ZZController zzController = new ZZController();
            controller.getMethod("setRequest", HttpServletRequest.class).invoke(o, request);
            controller.getMethod("setResponse", HttpServletResponse.class).invoke(o, response);
            Method m = controller.getMethod(method, null);
            Aop aop = m.getAnnotation(Aop.class);
            if (aop != null) {
                ZZInterceptor interceptor = (ZZInterceptor) ZZConfig.createSimpleBean(aop.interceptor());
                interceptor.before();
                m.invoke(o, null);
                interceptor.after();
            } else {
                m.invoke(o, null);
            }

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
