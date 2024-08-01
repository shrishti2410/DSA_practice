//Brute force-Traverse through the array and check its neighbours.
//TC=O(N)
//SC=O(1)

//TC=O(log base(2) N)
//SC=O(1)
public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int n= nums.length;
        if(n==1){
            return nums[0];
        }
        int low=1, high=n-2;
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        if(nums[n-1]!=nums[n-2]){
            return nums[n-1];
        }
        while (low<=high) {
            int mid = low + (high - low) / 2;
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]){
                return nums[mid];
            } else {
                if((mid%2==1 && nums[mid-1]==nums[mid]) || (mid%2==0 && nums[mid]==nums[mid+1])) {
                    low=mid+1;
                } else {
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}
