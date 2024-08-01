//The extremely naive approach is to check all possible distances from  [1, (max(stalls[])-min(stalls[]))]. The maximum distance for which the function canWePlace() returns true, will be our answer.
//TC=O(NlogN)+(O(log 2 (max-min))*O(N))

import java.lang.reflect.Array;
import java.util.Arrays;

public class AggressiveCows {
    public static boolean canWePlace(int[] stalls, int dist, int cows) {
        int n = stalls.length;
        int cntCows = 1;
        int last = stalls[0];
        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= dist) {
                cntCows++;
                last = stalls[i];
            }
            if (cntCows >= cows) return true;
        }
        return false;
    }
    public static int aggressiveCows(int[] stalls, int k) {
        int n=stalls.length;
        Arrays.sort(stalls);
        int low = 1, high = stalls[n - 1] - stalls[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(stalls, mid, k) == true) {
                low = mid + 1;
            } else high = mid - 1;
        }
        return high;
    }
}
