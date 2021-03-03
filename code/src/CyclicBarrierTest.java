import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 11:29 上午 2021/3/3
 * @Description：
 * @Modified By：
 * @Version: $
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        for (int i =0;i<4;i++){
            final int ii = i;
            new Thread(new Runnable() {
                @Override public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(ii*1000+1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            }).start();
        }
    }
}
