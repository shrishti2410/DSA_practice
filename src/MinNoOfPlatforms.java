import java.util.*;
public class MinNoOfPlatforms {
    public static void main(String[] args) {
        int[] arr ={900,945,955,1100,1500,1800};
        int[] dep={920,1200,1130,1150,1900,2000};
        int n=arr.length;
        int totalCount=findPlatform(arr,dep,n);
        System.out.println("Minimum number of Platforms required "+totalCount);
    }

    //Brute force
    //TC=O(N^2)
    //SC=O(1)
    static int findPlatform1(int arr[], int dep[], int n) {
        int maxCnt=0;
        for(int i=0; i<n-1; i++){
            int cnt=1;
            for(int j=i+1; j<n-1; j++){
                if((arr[i]>=arr[j] && arr[i]<=dep[j]) || (arr[j]>=arr[i] && arr[j]<=dep[i])){
                    cnt++;
                }
                maxCnt=Math.max(maxCnt,cnt);
            }
        }
        return maxCnt;
    }

    //Optimal
    //TC=O(2(NlogN+N)
    //SC=O(1)
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {

            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            }

            else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }

            if (plat_needed > result)
                result = plat_needed;
        }

        return result;
    }
}
