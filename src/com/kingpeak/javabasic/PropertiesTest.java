package com.kingpeak.javabasic;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * 继承hashtable， 持久的属性集， 键值都是字符串.
 * url: http://www.runoob.com/java/java-properties-class.html
 * @date 20181126
 */
public class PropertiesTest {
    public static void main(String[] args) {

        Properties capitals = new Properties();
        Set states;
        String str;

        capitals.put("Illision", "Springfield");
        capitals.put("Missouri", "Jefferson City");
        capitals.put("Washington", "Olympia");
        capitals.put("California", "Sacramento");
        capitals.put("Indiana", "Indianapolis");


        states = capitals.keySet();
        Iterator itr = states.iterator();
        while (itr.hasNext()) {
            str = (String)itr.next();
            System.out.println("the capital of " + str + " is " + capitals.getProperty(str) + ".");
        }
        System.out.println();

        str = capitals.getProperty("Florida", "Not Found");
        System.out.println("the capital of Florida is " + str + ".");
        System.exit(0);
    }
}
