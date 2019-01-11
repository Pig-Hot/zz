package mvc.common.utils;

/**
 * Created by zhuran on 2019/1/11 0011
 */
public class StringKit {
    public static String fristCharToLowerCase(String str){
        char fristChar = str.charAt(0);
        if(fristChar >= 'A' && fristChar <= 'Z'){
            char[] arr = str.toCharArray();
            arr[0] += ('a' - 'A');
            return new String(arr);
        }
        return str;
    }
}
