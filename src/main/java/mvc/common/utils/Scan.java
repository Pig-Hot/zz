package mvc.common.utils;

import mvc.annotation.Bean;
import mvc.annotation.Controller;
import mvc.common.Constant;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuran on 2019/1/14 0014
 */
public class Scan {
    public static void scan(Constant constant) {
        //拿到classes绝对路劲
        String path = Scan.class.getClassLoader().getResource("").getPath();
        List<String> list = listClassFileAbsolutePath(path);
        for (String str : list) {
            try {
                Class clazz = Class.forName(str);
                if (clazz != null) {
                    Controller controller = (Controller) clazz.getAnnotation(Controller.class);
                    Bean bean = (Bean) clazz.getAnnotation(Bean.class);
                    if (controller != null) {
                        constant.setRoute(controller.path(), clazz);
                    }
                    if (bean != null) {
                        constant.setBean(bean.name(), clazz.newInstance());
                    }
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<String> listClassFileAbsolutePath(String filePath) {
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

    private static List<String> listFileAbsolutePath(String filePath, List<String> list) {

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
