import java.util.*;
public class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        int low=0, high=n-1;
        while (low<=high){
            int mid=low+(high-low)/2;

            if(nums[low]<=nums[high]){
                ans=Integer.min(ans,nums[low]);
                break;
            }

            if(nums[low]<=nums[mid]){
                ans=Integer.min(ans,nums[low]);
                low=mid+1;
            } else {
                ans=Integer.min(ans,nums[mid]);
                high=mid-1;
            }
        }
        return ans;
    }
}
