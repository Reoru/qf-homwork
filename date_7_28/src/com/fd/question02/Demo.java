package com.fd.question02;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/7/28 0028 下午 21:08
 */
public class Demo {
    public static void main(String[] args) {
        FutureTask<String> taskByCompany = new FutureTask<>(new Company());
        FutureTask<String> taskByHome = new FutureTask<>(new HomeThing());

        Thread tCompany = new Thread(taskByCompany);
        Thread tHome = new Thread(taskByHome);
        Thread tVip = new WithVip();
        try {
            tCompany.start();
            tCompany.join();
            System.out.println(taskByCompany.get());

            tVip.start();
            tVip.join();

            tHome.start();
            System.out.println(taskByHome.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}


class Company implements Callable {
    @Override
    public String call() {
        Thread.currentThread().setName("公司事：");
        System.out.println(Thread.currentThread().getName() + "给各部门总监开会.");
        return Thread.currentThread().getName() + "开除那个不靠谱的副总经理.";
    }
}


class HomeThing implements Callable {
    @Override
    public String call() throws Exception {
        Thread.currentThread().setName("家里事：");
        System.out.println(Thread.currentThread().getName() + "去机场接女儿送到公司旁边的希尔顿饭店休息.");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "辅导儿子做作业.");
        return Thread.currentThread().getName() + "去香港给妻子买个6 Plus作为生日礼物.\n" + Thread.currentThread().getName() + "陪老妈去医院看腰间盘突出.";
    }
}


class WithVip extends Thread {
    @Override
    public void run() {
        Thread.currentThread().setName("客户事：");

        long start = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + "吃饭.");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "打牌.");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "KTV.");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "桑拿.");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "按摩.");

        System.out.println("陪VIP所耗时间：" + (System.currentTimeMillis() - start));
    }
}