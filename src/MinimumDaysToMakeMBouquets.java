//TC=O((log base 2(maxi-mini+1))*(N))
public class MinimumDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;
        int ans = minDays(arr, k, m);
        if (ans == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans);
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length;
        if (val > n) {
            return -1;
        }

        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }

        int left = mini, right = maxi;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canBloom(bloomDay, mid, m, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    private static boolean canBloom(int[] bloomDay, int day, int m, int k) {
        int n = bloomDay.length;
        int cnt = 0;
        int noOfB = 0;
        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= day) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }
}
