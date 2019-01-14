package test;

import mvc.filter.ZZInterceptor;

/**
 * Created by zhuran on 2019/1/14 0014
 */
public class MyIntercept implements ZZInterceptor {
    @Override
    public void before() {
        System.out.println("before");
    }

    @Override
    public void after() {
        System.out.println("after");
    }

    @Override
    public void exception() {
        System.out.println("exception");
    }
}
