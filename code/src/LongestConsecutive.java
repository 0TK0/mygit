/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 3:07 下午 2021/2/20
 * @Description：最长连续子序列
 * @Modified By：
 * @Version: $
 */
public class LongestConsecutive {
    public static int longestConsecutive(int[] nums){
        int max = Integer.MIN_VALUE;
        for (int num : nums){
            if (num < 0){
                num = -num;
            }
            if (num>max){
                max = num;
            }
        }
        byte[] bitMap = new byte[2*max+1];

        for (int num : nums){
            bitMap[num+max] = 1;

        }
        int cnt = 0;
        int maxCnt = 0;
        for (int i = 0;i <= 2*max;i++){
            if (bitMap[i] > 0){
                cnt++;
                if (cnt >= maxCnt){
                    maxCnt = cnt;
                }
                continue;
            }
            cnt = 0;

        }
        return maxCnt;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,-1,-3};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }
}
