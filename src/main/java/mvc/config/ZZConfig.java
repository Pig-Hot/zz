package mvc.config;

import mvc.common.Constant;
import mvc.filter.handle.ActionHandle;

/**
 * 用于读取配置信息
 * Created by zhuran on 2019/1/9 0009
 */
public abstract class ZZConfig {

    public static Constant CONSTANT = new Constant();
    private ActionHandle actionHandle = new ActionHandle();
    public static BeanFactory beanFactory = new BeanFactory();

    //初始化参数
    public void init() {
        setInitParam(CONSTANT);
        setRoute(CONSTANT);
    }

    public abstract void setInitParam(Constant constant);

    //设置路由
    public void setRoute(Constant constant) {

    }

    //请求Handle
    public ActionHandle getActionHandle() {
        return actionHandle;
    }

}
