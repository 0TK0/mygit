/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 1:49 下午 2021/2/20
 * @Description：
 * @Modified By：
 * @Version: $
 */
public class SearchLoopSorted2 {
    public static boolean search(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int h = len-1;
        int mid;
        while (l <= h){
            mid = (l+h)/2;
            if (target == nums[mid]){
                return true;
            }
            if (nums[mid] > nums[h]){
                if (target >= nums[l] && target < nums[mid]){
                    h = mid-1;
                } else {
                    l = mid+1;
                }
            } else if(nums[mid] < nums[h]){
                if (target > nums[mid] && target<=nums[h]){
                    l = mid+1;
                } else {
                    h = mid-1;
                }
            } else {
                h -=1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,1,1};
        boolean search = search(nums, 0);

    }
}
