package com.kingpeak.javabasic;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Dictionary的具体实现, 类似 HashMap，但是Hashtable 支持同步.
 * url: http://www.runoob.com/java/java-hashTable-class.html
 * @date 20181124
 */
public class HashTableTest {

    public static void main(String[] args) {
        Hashtable balance = new Hashtable();
        Enumeration names;
        String str;
        double bal;

        balance.put("Zara", new Double(3434.34));
        balance.put("Mahna", new Double(1234.34));
        balance.put("Ayan", new Double(8734.12));
        balance.put("Benz", new Double(3555.99));

        names = balance.keys();
        while (names.hasMoreElements()) {
            str = (String) names.nextElement();
            System.out.println(str + " : " + balance.get(str));
        }
        System.out.println();
        bal = ((Double) balance.get("Zara")).doubleValue();
        balance.put("Zara", new Double(bal + 800));
        System.out.println("Zara new balance: " + balance.get("Zara"));
    }
}
