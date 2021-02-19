/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 4:32 下午 2021/2/19
 * @Description：搜索旋转排序数组
 * @Modified By：
 * @Version: $
 */
public class SearchLoopSorted {
    public static int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int h = len-1;
        int mid;
        while(l<=h){
            mid = (l+h)/2;
            if (target == nums[mid]){
                return mid;
            }
            if (nums[mid] >= nums[l]){
                if (target >= nums[l] && target < nums[mid]){
                    h = mid-1;
                } else {
                    l = mid+1;
                }
            } else {
                if (target > nums[mid] && target <= nums[h]) {
                    l = mid +1;
                } else {
                    h = mid -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1};
        int search = search(nums, 1);
        System.out.println(search);
    }
}
