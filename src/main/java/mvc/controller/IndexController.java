package mvc.controller;

import mvc.annotation.Bean;
import mvc.annotation.Controller;

/**
 * Created by zhuran on 2019/1/14 0014
 */
@Controller(path = "/", name = "IndexController")
public class IndexController extends ZZController {

    public void index() {
        render("/WEB-INF/views/index.html");
    }

    public void baidu(){
        redirect("http://www.baidu.com");
    }
}
