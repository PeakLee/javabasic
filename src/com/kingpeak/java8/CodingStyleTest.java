package com.kingpeak.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * date: 20181120
 * url: http://www.runoob.com/java/java8-new-features.html
 * java8 新的编程风格 lambda
 */
public class CodingStyleTest {

    public static void main(String[] args) {
        List<String> names1 = new ArrayList<>();
        names1.add("Google ");
        names1.add("Baidu");
        names1.add("Taobao");
        names1.add("Sina");
        List<String> names2 = new ArrayList<>();
        names2.add("Google ");
        names2.add("Baidu");
        names2.add("Taobao");
        names2.add("Sina");

        System.out.println("using java7 style: ");
        sortUsingJava7(names1);
        System.out.println("sorted names using java7: " + names1);

        System.out.println("using java8 style: ");
        sortUsingJava7(names2);
        System.out.println("sorted names using java8: " + names2);

        System.exit(0);
    }

    // 使用Java7 排序.
    private static void sortUsingJava7(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

    }

    // 使用java8 排序
    private static void sortUsingJava8(List<String> names) {
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }

}
