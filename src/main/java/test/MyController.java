package test;

import mvc.annotation.Aop;
import mvc.annotation.Controller;
import mvc.config.ZZConfig;
import mvc.controller.ZZController;


/**
 * Created by zhuran on 2019/1/9 0009
 */
@Controller(path = "/my")
public class MyController extends ZZController {

    @Aop(interceptor = MyIntercept.class)
    public void index() {
        MyBean myBean = (MyBean) ZZConfig.CONSTANT.getBean("myBean");
        myBean = (MyBean) getObject(myBean.getClass());
        System.out.println(myBean.getName());
    }

}
