//TC=O((log base 2(maxi))*(N))
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int maxi = Integer.MIN_VALUE;
        int sum=0;

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, weights[i]);
        }
        for (int i = 0; i < n; i++) {
            sum = sum+weights[i];
        }

        int low=maxi, high=sum;
        while (low<high){
            int mid=low+(high-low)/2;
            int numberOfDays = findDays(weights, mid);
            if (numberOfDays <= days) {
                high=mid;
            } else {
                low=mid+1;
            }
        }
        return low;
    }
    public int findDays(int[] weights, int cap){
        int days = 1;
        int load = 0;
        int n = weights.length;
        for (int i = 0; i < n; i++) {
            if (load + weights[i] > cap) {
                days += 1;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }
        return days;
    }
}
