//TC=O(log base(2) N)
//SC=O(1)

import java.util.*;
public class BS {
    //Iterative
    public static int BS_i(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    //Recursive
    public static int BS_r(int[] nums, int low, int high, int target) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (nums[mid] == target) return mid;
        else if (target > nums[mid])
            return BS_r(nums, mid + 1, high, target);
        return BS_r(nums, low, mid - 1, target);
    }

    public static int search(int[] nums, int target) {
        return BS_r(nums, 0, nums.length - 1, target);
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6;
        int ind = BS_i(a, target);
        int ind1 = search(a, target);
        if (ind == -1)
            System.out.println("The target is not present.");
        else
            System.out.println("The target is at index: " + ind);
    }
}