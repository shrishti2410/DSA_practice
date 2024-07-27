//Brute force-Traverse through the array and check its neighbours.
//TC=O(N)
//SC=O(1)

//TC=O(log base(2) N)
//SC=O(1)
public class FindPeak {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int low=1, high=n-2, ans=0;
        if(n==1){
            return 0;
        }
        if(nums[0]>nums[1]){
            return 0;
        }
        if(nums[n-1]>nums[n-2]){
            return n-1;
        }
        while (low<=high) {
            int mid = (low) + (high - low) / 2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                //peak found
                return mid;
            } else if (nums[mid]>nums[mid-1]) {
                //eliminate left side
                low=mid+1;
            }else if(nums[mid]>nums[mid+1]) {
                //eliminate right side
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return -1;
    }
}
