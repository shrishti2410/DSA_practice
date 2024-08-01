//Brute force-
//TC=O(N)

//Optimal-
//TC=O(logN)
public class KthMissingPositiveNumber {
    //Brute force
    public static int missingK(int[] vec, int n, int k) {
        for (int i = 0; i < n; i++) {
            if (vec[i] <= k) k++;
            else break;
        }
        return k;
    }
    //Optimal
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + high + 1;
    }
}
