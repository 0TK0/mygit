/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 11:15 上午 2021/2/20
 * @Description：
 * @Modified By：
 * @Version: $
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        if (nums == null){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int maxSum = nums[0];
        int cur = nums[0];
        for (int i = 1;i < nums.length;i++){
            if (cur < 0 && nums[i] > cur){
                maxSum = nums[i];
                cur = nums[i];
                continue;
            }
            if (cur+nums[i] >= maxSum){
                cur +=nums[i];
                maxSum = cur;
                continue;
            }
            if (cur+nums[i] >=0){
                cur +=nums[i];
                continue;
            }
            if (cur+nums[i] < 0){
                cur = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,2};
        int i = maxSubArray(nums);
        System.out.println(i);
    }
}
