package test;

import mvc.common.Constant;
import mvc.config.ZZConfig;
import test.MyController;

/**
 * Created by zhuran on 2019/1/9 0009
 */
public class MyConfig extends ZZConfig {
    public void setInitParam(Constant constant) {
        System.out.println("配置文件初始化");
    }

    //设置路由
    public void setRoute(Constant constant) {
        constant.setRoute("/my", MyController.class);
    }
}
