package com.kingpeak.javabasic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

// 泛型测试： http://www.runoob.com/java/java-generics.html
// @TODO:  一共7种用法  @date: 20181120
public class GenericTest {


    //#1 通用泛型 方法.
    private static<D> void printArr(D[] input) {
        for (D element: input) {
            System.out.println(element);
        }
        System.out.println("finished print data.");
    }

    //#2 有界参数类型
    static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }

        return max;
    }

    //#3 泛型类
    static class Box<T> {
        private T t;
        public void set(T t) {
            this.t = t;
        }
        public T get() {
            return this.t;
        }
    }

    //#4 类型通配符
    private static void getData(List<?> data) {
        System.out.println("data first is: " + data.get(0));
    }

    //#5 类型通配符 限定类型.  上限
    static void getUpData(List<? extends Number> data) {
        System.out.println("data extends limited is : " + data.get(0));
    }

    //#6 类型通配符 限定类型. 下限
    static void getDnData(List<? super Integer> data) {
        System.out.println("data supper limited is :" + data.get(0));
    }

    //#7 泛型 programmer 在编译时检测到非法类型而已, 但是运行期， 泛型标志会转变为Object类型
    static void generalMc() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        // list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        add.invoke(list, "k1");
        System.out.println(list);
    }

    public static void main(String[] args) {
        Integer[] a = {1,2,3};
        printArr(a);
        System.out.println("1, 2, 3: max is: " + maximum(1,2,3));

        Box<Integer> intbox = new Box<Integer>();
        Box<String> strbox = new Box<String>();

      /*  intbox.set(new Integer(11));
        strbox.set(new String("fresh"));*/
        intbox.set(123);
        strbox.set("fresh ...");
        System.out.println("int value: " + intbox.get());
        System.out.println("string value: " + strbox.get());

        List<String> names = new ArrayList<>();
        List<Integer> ints = new ArrayList<>();
        names.add("hello world");
        ints.add(1234);
        getData(names);
        getData(ints);

        getUpData(ints);
//        getUpperData(names);
        getDnData(ints);

        // runtime test.
        try {
            generalMc();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}
