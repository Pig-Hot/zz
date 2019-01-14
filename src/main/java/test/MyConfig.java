package test;

import mvc.annotation.Controller;
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
}
