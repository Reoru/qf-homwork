package com.fd.question03;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author RRReoru
 * @version 1.0
 * @date 2020/7/28 0028 下午 20:42
 */
public class Demo {
    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask(new ThreadA());
        Thread threadA = new Thread(task);
        Thread threadB = new Thread(new ThreadB());
        threadB.setDaemon(true);
        threadB.start();
        threadA.start();
        try {
            Integer sum = task.get();
            System.out.println("偶数和：" + sum);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("主线程倒计时:" + (i+1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class ThreadA implements Callable {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 10000; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}


class ThreadB implements Runnable {
    @Override
    public void run() {
        Thread.currentThread().setName("子线程B");
        while (true) {
            System.out.println("当前线程名称是:" + Thread.currentThread().getName() + "   当前时间：" + LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}