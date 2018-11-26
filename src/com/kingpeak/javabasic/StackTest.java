package com.kingpeak.javabasic;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Vector的一个子类，实现标准的先进后出
 * url: http://www.runoob.com/java/java-stack-class.html
 * @date 20181124
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<Integer>();
        System.out.println("stack: " + st);

        showPush(st, 12);

        showPush(st, 44);
        showPush(st, 99);
        showPop(st);
        showPop(st);
        showPop(st);
        //System.exit(0);
        try {
            showPop(st);
        } catch (EmptyStackException e) {
            //e.printStackTrace();
            System.out.println("empty stack now.");
        }
        System.exit(0);
    }

    private static void showPush(Stack<Integer> st, int a) {
        st.push(new Integer(a));
        System.out.println("push (" + a + ")");
        System.out.println("statck: " + st);
    }
    private static void showPop(Stack<Integer> st) {
        System.out.println("pop -> ");
        Integer a = (Integer)st.pop();
        System.out.println("pop (" + a + ")");
        System.out.println("statck: " + st);
    }
}
