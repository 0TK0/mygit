import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 8:23 下午 2021/3/2
 * @Description：
 * @Modified By：
 * @Version: $
 */
public class PAndC {
    private static ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args) {
        Producer p = new PAndC().new Producer();
        Consumer c = new PAndC().new Consumer();
        Thread thread = new Thread(p);
        Thread thread1 = new Thread(c);
        thread.start();
        thread1.start();
    }


    class Producer implements Runnable{
        @Override public void run() {
            try {
                while (true){
                    arrayBlockingQueue.put(1);
                    System.out.println("produce");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Consumer implements Runnable{

        @Override public void run() {
            try {
                while (true){
                    arrayBlockingQueue.take();
                    System.out.println("consume");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
