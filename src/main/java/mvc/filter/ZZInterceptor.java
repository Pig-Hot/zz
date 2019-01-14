package mvc.filter;

/**
 * Created by zhuran on 2019/1/14 0014
 */
public interface ZZInterceptor {
    void before();

    void after();

    void exception();
}
