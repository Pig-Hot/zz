package test;

import mvc.annotation.Mapper;
import mvc.annotation.Sql;

/**
 * Created by zhuran on 2019/1/14 0014
 */
@Mapper
public class MyMapper {
    @Sql(sql = "hello")
    public void say(String s){
        System.out.println(s);
    }
}
