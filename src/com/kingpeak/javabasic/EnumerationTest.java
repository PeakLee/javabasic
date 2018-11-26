package com.kingpeak.javabasic;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 传统接口，已经被迭代器Iterator取代，被废弃掉了，遗留系统中存在， 主要两个方法: hasMoreElements(), nextElement()
 * url: http://www.runoob.com/java/java-enumeration-interface.html
 * @date 20181124
 */
public class EnumerationTest {

    public static void main(String[] args) {
        Enumeration<String> days;
        Vector<String> dayNames = new Vector<>();
        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        days = dayNames.elements();
        while (days.hasMoreElements()) {
            System.out.println(days.nextElement());
        }
        System.exit(0);
    }
}
