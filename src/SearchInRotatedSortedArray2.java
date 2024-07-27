//In the previous problem, where there were no duplicate numbers. However, in the current problem, the array may contain duplicates. T
// The previous approach will not work when arr[low] = arr[mid] = arr[high].
//How to handle the edge case arr[low] = arr[mid] = arr[high]:
//In the algorithm, we first check if arr[mid] is the target before identifying the sorted half. If arr[mid] is not our target, we encounter this edge case. In this scenario, since arr[mid] = arr[low] = arr[high], it means that neither arr[low] nor arr[high] can be the target. To handle this edge case, we simply remove arr[low] and arr[high] from our search space, without affecting the original algorithm.
//To eliminate elements arr[low] and arr[high], we can achieve this by simply incrementing the low pointer and decrementing the high pointer by one step. We will continue this process until the condition arr[low] = arr[mid] = arr[high] is no longer satisfied.

//TC=O(log base(2) N)
//TC for [3,3,1,3,3,3,3]=O(N/2)

import java.util.*;
public class SearchInRotatedSortedArray2 {
    public static boolean search(int []nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            //if mid points the target
            if (nums[mid] == target) return true;

            //Edge case:
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            //if left part is sorted:
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    //element exists:
                    high = mid - 1;
                } else {
                    //element does not exist:
                    low = mid + 1;
                }
            } else { //if right part is sorted:
                if (nums[mid] <= target && target <= nums[high]) {
                    //element exists:
                    low = mid + 1;
                } else {
                    //element does not exist:
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
        int k = 3;
        boolean ans = search(arr, k);
        if (ans == false)
            System.out.println("Target is not present.");
        else
            System.out.println("Target is present in the array.");
    }
}



