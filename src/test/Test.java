package test;

import java.util.concurrent.*;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("执行线程" + Thread.currentThread().getName());
    }
}
public class Test {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(5^1));
        System.out.println(Integer.toBinaryString(~5));
    }
}
