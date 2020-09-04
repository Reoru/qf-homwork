package com.fd.question04;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/7/27 0027 下午 19:56
 */
public class Demo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt(20) + 10);
        }
        int sum = 0;
        sum = sum(sum, list);
        System.out.println("sum = " + sum);
    }

    private static int sum(int sum, LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return sum(sum + list.remove(), list);
        }
        return sum;
    }
}
