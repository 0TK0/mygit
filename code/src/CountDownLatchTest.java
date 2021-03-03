import java.util.concurrent.CountDownLatch;

/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 11:32 上午 2021/3/3
 * @Description：
 * @Modified By：
 * @Version: $
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i = 0;i<4;i++){
            final int ii = i;
            new Thread(new Runnable() {
                @Override public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(ii*1000+1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }

                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
