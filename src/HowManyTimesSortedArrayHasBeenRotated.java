import java.util.*;
public class HowManyTimesSortedArrayHasBeenRotated {
    public static void main(String[] args) {

    }
    public int findK(int[] nums) {
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        int low=0, high=n-1;
        int index=-1;
        while (low<=high){
            int mid=low+(high-low)/2;

            if(nums[low]<=nums[high]){
                if(nums[low]<=ans){
                    index=low;
                    ans=nums[low];
                }
                break;
            }

            if(nums[low]<=nums[mid]){
                if(nums[low]<=ans){
                    index=low;
                    ans=nums[low];
                }
                low=mid+1;
            } else {
                if(nums[mid]<=ans){
                    index=mid;
                    ans=nums[mid];
                }
                high=mid-1;
            }
        }
        return index;
    }
}
