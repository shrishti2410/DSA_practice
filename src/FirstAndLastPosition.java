import java.util.*;
public class FirstAndLastPosition {
    public static void main(String[] args) {
        int n = 1;
        int key = 1;
        int[] v = {1};
        System.out.println(searchRange(v, key));
    }
    public static int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int first=-1, last=-1;
        int[] arr=new int[2];
        while (low<=high){
            int mid=(low)+(high-low)/2;
            if(nums[mid]==target){
                first=mid;
                last=mid;

                while (first>=0 && nums[first]==target){
                    first--;
                }

                while (last<=n-1 && nums[last]==target){
                    last++;
                }

                break;
            } else if (nums[mid]>target) {
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        if(first==-1 && last==-1){
            arr[0]=-1;
            arr[1]=-1;
        } else {
            arr[0]=first+1;
            arr[1]=last-1;
        }

        return arr;
    }
}
