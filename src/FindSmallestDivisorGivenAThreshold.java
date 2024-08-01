//TC=O((log base 2(maxi))*(N))
public class FindSmallestDivisorGivenAThreshold {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int limit = 8;
        int ans = smallestDivisor(arr, limit);
        System.out.println("The minimum divisor is: " + ans);
    }
    public static int smallestDivisor(int[] nums, int threshold){
        int n = nums.length;
        if (threshold < n) {
            return -1;
        }

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        int left = 1, right = maxi;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((canHold(nums, mid))<=threshold) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private static int canHold(int[] nums, int num) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += (int) Math.ceil((double) nums[i] / num);
        }
        return cnt;
    }
}
