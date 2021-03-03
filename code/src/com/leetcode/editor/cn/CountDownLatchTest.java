package com.leetcode.editor.cn;

import java.util.concurrent.CountDownLatch;

/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 10:49 上午 2021/3/1
 * @Description：
 * @Modified By：
 * @Version: $
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch cdl = new CountDownLatch(2);
        System.out.println("开始");
        Runnable runnable = new Runnable() {
            @Override public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("haha" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    cdl.countDown();
                }
            }
        };

        Runnable runnable1 = new Runnable() {
            @Override public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println("xixi" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    cdl.countDown();
                }
            }
        };

        try {
            Thread thread1 = new Thread(runnable);
            Thread thread2 = new Thread(runnable1);
            thread1.start();
            thread2.start();
            System.out.println("等待执行完");
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完了");
    }
}
