package com.leetcode.editor.cn;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 12:22 下午 2021/3/1
 * @Description：
 * @Modified By：
 * @Version: $
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        for (int i = 0;i<4;i++){
            final int ii= i;
            Runnable runnable = new Runnable() {
                @Override public void run() {
                    try {
                        if (ii == 2) {
                            Thread.sleep(3000);
                        }
                        Thread.sleep(3000);
                        System.out.println("one" + Thread.currentThread().getName());
                        cyclicBarrier.await();
                        System.out.println("continue" + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.submit(runnable);
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完成");
        executorService.shutdown();
    }

//    public static void main(String[] args) {
//        ExecutorService service = Executors.newCachedThreadPool();
//        final  CyclicBarrier cb = new CyclicBarrier(3);//创建CyclicBarrier对象并设置3个公共屏障点
//        for(int i=0;i<3;i++){
//            Runnable runnable = new Runnable(){
//                public void run(){
//                    try {
//                        Thread.sleep((long)(Math.random()*10000));
//                        System.out.println("线程" + Thread.currentThread().getName() +
//                            "即将到达集合地点1，当前已有" + cb.getNumberWaiting() + "个已经到达，正在等候");
//                        cb.await();//到此如果没有达到公共屏障点，则该线程处于等待状态，如果达到公共屏障点则所有处于等待的线程都继续往下运行
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
//            service.execute(runnable);
//        }
//        service.shutdown();
//    }
}
