package test;

import mvc.annotation.Aop;
import mvc.controller.ZZController;
import mvc.modle.User;


/**
 * Created by zhuran on 2019/1/9 0009
 */

public class MyController extends ZZController {

    @Aop(interceptor = MyIntercept.class)
    public void index() {
        System.out.println("index");
    }

    public User getUser(){
        return null;
    }

    public void add() {
        render("/WEB-INF/views/add.html");
//        renderString(getRequest().getParameter("content"));
    }

     public void baidu(){
        redirect("http://www.baidu.com");
     }
}
