package test;

import mvc.annotation.Bean;

/**
 * Created by zhuran on 2019/1/14 0014
 */
@Bean(name = "myBean")
public class MyBean {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
