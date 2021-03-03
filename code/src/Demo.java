import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 10:18 下午 2021/2/20
 * @Description：
 * @Modified By：
 * @Version: $
 */
public class Demo {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length;i++){
            dp[i] =1;
            for (int j = 0;j <=i;j++){
                if (nums[i]> nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max = 0;
        for (int i = 0;i < nums.length;i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int abcabcbb = lengthOfLIS(new int[]{0,1,0,3,2,3});
        System.out.println(abcabcbb);
    }

}
