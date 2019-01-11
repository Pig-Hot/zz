package mvc.common.utils;

/**
 * Created by zhuran on 2019/1/9 0009
 */
public class UrlKit {
    /**
    返回一个数组，第一个表示controller的路由，第二个是对应的方法
     */
    public static String[] getUriTail(String uri,String contextPath){
        String result[] = {"",""};
        String s = uri.substring(contextPath.length(),uri.length());
        if(s.length()>0){
            if(s.endsWith("/")){
                result[0] = s;
                result[1] = "index";
            }else {
                String ss[] = s.split("/");
                if(ss.length>2){
                    result[0] = s.substring(0,s.length() - ss[ss.length-1].length());
                    result[1] = ss[ss.length-1];
                }else if(ss.length==2){
                    result[0] = "/" + ss[1];
                    result[1] = "index";
                }
            }
            if(result[0].length() > 1 && result[0].endsWith("/")){
                result[0] = result[0].substring(0,result[0].length() - 1);
            }
        }
        return result;
    }

}
