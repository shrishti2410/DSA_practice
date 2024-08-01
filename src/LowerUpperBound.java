//Lower bound-Smallest index such that, arr[index]>=x
//TC=O(log base(2) N)
//SC=O(1)
//For C++ users-lb=lower_bound(arr.begin(),arr.end(),n)-(arr.begin();

//Upper bound-Smallest index such that, arr[index]>x
//TC=O(log base(2) N)
//SC=O(1)
//For C++ users-lb=upper_bound(arr.begin(),arr.end(),n)-(arr.begin();


import java.util.*;
public class LowerUpperBound {

    static int LB(int arr[], int target, int n){
        int low=0, high=n-1, ans=n;
        while (low<=high){
            int mid=(low)+(high-low)/2;
            if(arr[mid]>=target){
                ans=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return ans;
    }
    static int UB(int arr[], int target, int n){
        int low=0, high=n-1, ans=n;
        while (low<=high){
            int mid=(low)+(low-high)/2;
            if(arr[mid]>target){
                ans=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] a = {3, 4, 6, 7, 9, 12, 16, 17};
    }
}