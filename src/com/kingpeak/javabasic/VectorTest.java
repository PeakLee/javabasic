package com.kingpeak.javabasic;

import java.util.Enumeration;
import java.util.Vector;

/**
 *  和ArrayList 不同： 同步访问， 传统方法不属于集合框架.
 *  4种构造函数: Vector(), Vector(int size), Vector(int size, int cncr), Vector(Collection c)
 *  url:http://www.runoob.com/java/java-vector-class.html
 * @date 20181124
 */

public class VectorTest {

    public static void main(String[] args) {
        Vector v = new Vector(3, 2);
        System.out.println("init size: " + v.size() + ", capacity: " + v.capacity());
        v.addElement(new Integer(1));
        v.addElement(2);
        System.out.println("init size: " + v.size() + ", capacity: " + v.capacity());

        v.add(3.3);
        v.add("hell worl ");
        System.out.println("init size: " + v.size() + ", capacity: " + v.capacity());

        Enumeration enums = v.elements();
        while (enums.hasMoreElements()) {
            System.out.println(enums.nextElement());
        }
        System.exit(0);
    }
}
