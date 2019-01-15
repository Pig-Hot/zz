package mvc.factory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuran on 2019/1/15 0015
 */
public class CommonPath {
    public static List<String> listClassFileAbsolutePath(String filePath) {
        List<String> list = new ArrayList<>();
        List<String> classList = new ArrayList<>();
        listFileAbsolutePath(filePath, list);
        for (String s : list) {
            //找到class类
            if (s.endsWith(".class")) {
                String ss = s.substring(filePath.length() - 1);
                String prefix = ss.substring(0, ss.length() - 6).replace("\\", ".");
                classList.add(prefix);
            }
        }
        return classList;
    }

    public static List<String> listFileAbsolutePath(String filePath, List<String> list) {

        File root = new File(filePath);
        File[] files = root.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                /*
                 * 递归调用
                 */
                listFileAbsolutePath(file.getAbsolutePath(), list);
            } else {
                list.add(file.getAbsolutePath());

            }
        }
        return list;
    }
}
