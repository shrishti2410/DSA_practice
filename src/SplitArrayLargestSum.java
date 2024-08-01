public class SplitArrayLargestSum {
        public static int countPartitions(int[] a, int maxSum) {
        int n = a.length; //size of array.
        int partitions = 1;
        long subarraySum = 0;
        for (int i = 0; i < n; i++) {
            if (subarraySum + a[i] <= maxSum) {
                //insert element to current subarray
                subarraySum += a[i];
            } else {
                //insert element to next subarray
                partitions++;
                subarraySum = a[i];
            }
        }
        return partitions;
    }

    public static int splitArray(int[] nums, int k) {
        int low = nums[0];
        int high = 0;
        //find maximum and summation:
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        //Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int partitions = countPartitions(nums, mid);
            if (partitions > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
