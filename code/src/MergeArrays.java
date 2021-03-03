/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 3:39 下午 2021/2/23
 * @Description：
 * @Modified By：
 * @Version: $
 */
public class MergeArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j = n-1;
        int k = 0;
        while(i >= 0 || j >= 0){
            if (i < 0){
                nums1[m+n-1-k] = nums2[j];
                j--;
                k++;
                continue;
            }
            if (j < 0){
                nums1[m+n-1-k] = nums1[i];
                i--;
                k++;
                continue;
            }
            if (nums1[i] > nums2[j]){
                nums1[m+n-1-k] = nums1[i];
                i--;
                k++;
                continue;
            }
            nums1[m+n-1-k] = nums2[j];
            j--;
            k++;
        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,5,8,0,0,0,0,0,0};
        int[] nums2 = new int[]{2,3,4,6,7,9};
        merge(nums1,4,nums2,6);
        System.out.println(nums1);
    }
}
