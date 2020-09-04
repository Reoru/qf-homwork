package com.fd.question01;

import java.util.Random;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/7/28 0028 下午 20:21
 */
public class Demo {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Number());
        Thread t2 = new Thread(new Word());
        t1.start();
        t2.start();

    }
}


class Number implements Runnable {
    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int num = random.nextInt(10);
            if (num % 200 == 0) {
                System.out.println("已让出CPU时间片...");
                Thread.yield();
            }
            System.out.println(num);
        }
    }
}

class Word implements Runnable {
    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            char word = (char) (random.nextInt(26) + 97);
            System.out.println(word);
        }
    }
}