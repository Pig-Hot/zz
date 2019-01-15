package test;

import mvc.annotation.Aop;
import mvc.annotation.Controller;
import mvc.annotation.Register;
import mvc.controller.ZZController;


/**
 * Created by zhuran on 2019/1/9 0009
 */
@Controller(path = "/my",name = "MyController")
public class MyController extends ZZController {

    @Register
    public MyBean myBean;

    public void setMyBean(MyBean myBean) {
        this.myBean = myBean;
    }

    @Aop(interceptor = MyIntercept.class)
    public void index() {
        System.out.println(myBean.getName());
    }

}
