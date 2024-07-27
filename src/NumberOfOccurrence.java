public class NumberOfOccurrence {
    int count(int[] arr, int n, int x) {
        int low=0;
        int high=n-1;
        int first=-1, last=-1;
        int arr1=0;
        while (low<=high){
            int mid=(low)+(high-low)/2;
            if(arr[mid]==x){
                first=mid;
                last=mid;

                while (first>=0 && arr[first]==x){
                    first--;
                }

                while (last<=n-1 && arr[last]==x){
                    last++;
                }

                break;
            } else if (arr[mid]>x) {
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        if(first==-1 && last==-1){
            arr1=0;
        } else {
            arr1=(last-1)-(first+1)+1;
        }
        return arr1;
    }
}
