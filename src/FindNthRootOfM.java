//Brute force-liner search
//TC=O(M*log (base 2) M)

//Optimal-binary search
//TC=O(log (base 2) N * log (base 2) N)
public class FindNthRootOfM {
    public int NthRoot(int n, int m) {
        int low=1, high=m, ans=0;
        while (low<=high){
            int mid=low+(high-low)/2;
            if(Math.pow(mid,n)==m){
                return mid;
            } else if (Math.pow(mid,n)<m) {
                low=mid+1;
            } else {
                high=mid-1;
            }
        }
        return -1;
    }
}
