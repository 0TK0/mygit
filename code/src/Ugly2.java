import java.util.ArrayList;
import java.util.List;

/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 10:33 下午 2021/2/21
 * @Description：
 * @Modified By：
 * @Version: $
 */
public class Ugly2 {
    public static int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
        int i =1;
        list.add(i);
        while(list.size()<n){
            i++;
            if (isUgly(i)){
                list.add(i);
            }
        }
        return list.get(n-1);
    }

    private static boolean isUgly(int num) {
        boolean hasCal = true;
        while(num > 0 && hasCal){
            hasCal = false;
            if (num%2 == 0){
                num /=2;
                hasCal = true;
            }
            if (num%3 == 0){
                num /=3;
                hasCal = true;
            }
            if (num%5 == 0){
                num /= 5;
                hasCal = true;
            }
        }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
