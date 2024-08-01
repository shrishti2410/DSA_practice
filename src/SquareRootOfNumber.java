//Brute force-Traverse through all the numbers.
//TC=O(N)
//SC=O(1)

//TC=O(log base(2) N)
//SC=O(1)
public class SquareRootOfNumber {
    long floorSqrt(long x) {
        long low=1, high =x;
        long ans=0;
        while (low<=high) {
            long mid=low+(high-low)/2;
            if(mid*mid<=x){
                ans=mid;
                low=mid+1;
            } else {
                high=mid-1;
            }
        }
        return ans;
    }
}
