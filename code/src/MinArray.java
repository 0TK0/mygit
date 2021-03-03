/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 7:17 下午 2021/2/19
 * @Description：
 * @Modified By：
 * @Version: $
 */
public class MinArray {
    public static int minArray(int[] numbers) {
        int l = 0;
        int h = numbers.length-1;
        int mid;
        while(l<h){
            mid = (l+h)/2;
            if (numbers[mid] > numbers[h]){
                l = mid+1;
            } else if(numbers[mid] < numbers[h]){
                h = mid;
            } else {
                h -=1;
            }
        }
        return numbers[l];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,0,1};
        int i = minArray(nums);
        System.out.println(i);
    }
}
