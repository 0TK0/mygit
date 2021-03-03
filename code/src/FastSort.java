/**
 * @Author ：zhuyuqing.
 * @Date ：Created in 2:53 下午 2021/2/23
 * @Description：
 * @Modified By：
 * @Version: $
 */
public class FastSort {

    public void fastSort(int[] nums){
        if (nums == null){
            return;
        }
        sort(nums,0,nums.length-1);
    }

    private void sort(int[] nums,int l,int h){
        if (h<=l){
            return;
        }
        int j = partition(nums,l,h);
        sort(nums,l,j-1);
        sort(nums,j+1,h);
    }

    private int partition(int[] nums,int l,int h){
        int i = l;
        int j = h+1;
        int p = nums[l];
        while (true){
            while(nums[++i]<p){
                if (i == h){
                    break;
                }
            }
            while (nums[--j]>p){
                if (j == l){
                    break;
                }
            }
            if (i>=j){
                break;
            }
            exch(nums,i,j);
        }
        exch(nums,l,j);
        return j;
    }

    private void exch(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
