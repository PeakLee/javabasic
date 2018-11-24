package com.kingpeak.java8;

/**
 * date: 20181120
 * Lambda 把函数作为方法参数传进去，代码更加简洁和紧凑   （参考 javascript 闭包）
 * url: http://www.runoob.com/java/java8-lambda-expressions.html
 * (parameters) -> expression
 * (parameters) -> { statements; }
 */
public class LambdaTest {

    final static int magic_num = 123;

    public static void main(String[] args) {
        MathOperation addition = (int a, int b) -> a + b;
        MathOperation subtraction = (int a, int b) -> a - b;
        MathOperation multiplication = (int a, int b) -> a * b;
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + addition.operation(10, 5));
        System.out.println("10 + 6 = " + operate(10, 6, addition));
        System.out.println("10 - 6 = " + operate(10, 6, subtraction));
        System.out.println("10 * 6 = " + operate(10, 6, multiplication));
        System.out.println("10 / 6 = " + operate(10, 6, division));
        // System.out.println("10 + 6 = " + operate(10, 6, addition));

        GreetingService greeting1 = message -> System.out.println("Hello " + message);
        GreetingService greeting2 = message -> System.out.println(magic_num + message);
        greeting1.sayMessage("google");
        greeting2.sayMessage("baidu");


        // anonymous inner class.
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello thread world !");
            }
        }).start();

        new Thread(() -> System.out.println("Hello Thread World !")).start();



        System.exit(0);
    }

    interface MathOperation {
        int operation(int a, int b);
        default int addition (int a, int b) {
            return a + b;
        }
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private static int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
