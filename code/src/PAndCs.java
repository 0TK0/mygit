import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 5:47 下午 2021/3/2
 * @Description：
 * @Modified By：
 * @Version: $
 */
public class PAndCs {

    private static final Object lock = new Object();


    public static void main(String[] args) {
        Producer p = new PAndCs().new Producer();
        Consumer c = new PAndCs().new Consumer();
        Thread thread1 = new Thread(p);
        Thread thread2 = new Thread(c);
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();
    }

    class Producer implements Runnable{

        @Override public void run() {
            while (true){
                synchronized (lock){
                    System.out.println("producer"+Res.list.size());
                    if (Res.list.size()!=0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Res.list.add(1);
                    System.out.println("producer生产了一个消息");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                }

            }
        }
    }

    class Consumer implements Runnable{

        @Override public void run() {
            while (true){
                synchronized (lock){
                    System.out.println("consumer"+Res.list.size());
                    if (Res.list.size() == 0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Res.list.remove(0);
                    System.out.println("Consumer消费了一个消息");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                }
            }
        }
    }

    private static class Res{
        static ArrayList<Integer> list = new ArrayList<>();
    }
}
