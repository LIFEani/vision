package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args){
        //T1();
        T2();
    }
    public static void T1() {
        final List<Integer> arrayList = new ArrayList<>();
        // 创建两个线程
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                arrayList.add(i);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                arrayList.add(i);
            }
        });
        // 启动两个线程
        thread1.start();
        thread2.start();
        // 等待两个线程执行完毕
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 输出 ArrayList 的大小
        System.out.println("ArrayList size: " + arrayList.size());
    }
    public static <T> void T2() {
        final List<Integer> arrayList = new ArrayList<>();
        // 创建两个线程
        Thread thread1 = new Thread(() -> {
            synchronized (arrayList) {
                for (int i = 0; i < 1000; i++) {
                    arrayList.add(i);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (arrayList) {
                for (int i = 1000; i < 2000; i++) {
                    arrayList.add(i);
                }
            }
        });
        // 启动两个线程
        thread1.start();
        thread2.start();
        // 等待两个线程执行完毕
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 输出 ArrayList 的大小
        System.out.println("ArrayList size: " + arrayList.size());
    }
}









