//Brute force-Create a new array and combine both these arrays

//Better-To optimize the space used in the previous approach, we can eliminate the third array used to store the final merged result. After closer examination, we realize that we only need the two middle elements at indices (n1+n2)/2 and ((n1+n2)/2)-1, rather than the entire merged array, to solve the problem effectively.

//Optimal-Binary Search
//TC= O(log(min(n1,n2)))
public class MedianOfTwoSortedArraysOfDifferentSizes {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1= nums1.length;
        int n2=nums2.length;
        int n=n1+n2;
        if(n1>n2){
            return findMedianSortedArrays(nums2,nums1);
        }
        int low=0, high=n1;
        int left=(n1+n2+1)/2;
        while (low<=high){
            int mid1=(low+high)/2;
            int mid2=(left-mid1);
            int l1=Integer.MIN_VALUE, l2=Integer.MIN_VALUE, r1=Integer.MAX_VALUE, r2=Integer.MAX_VALUE;
            if(mid1<n1){
                r1=nums1[mid1];
            }
            if(mid2<n2){
                r2=nums2[mid2];
            }
            if(mid1-1>=0){
             l1=nums1[mid1-1];
            }
            if(mid2-1>=0){
                l2=nums2[mid2-1];
            }

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0;
    }
}
