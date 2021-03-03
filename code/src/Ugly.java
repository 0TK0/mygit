/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 10:25 下午 2021/2/21
 * @Description：
 * @Modified By：
 * @Version: $
 */
public class Ugly {
    public static boolean isUgly(int num) {
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
        System.out.println(isUgly(14));
    }
}
