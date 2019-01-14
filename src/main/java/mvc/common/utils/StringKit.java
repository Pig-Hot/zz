package mvc.common.utils;

/**
 * Created by zhuran on 2019/1/11 0011
 */
public class StringKit {
    public static String fristCharToLowerCase(String str) {
        char[] chars = str.toCharArray();
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[0] = (char) (chars[0] - 32);
        }
        return new String(chars);
    }
}
