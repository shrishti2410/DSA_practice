//TC=O(N * log(sum(arr[])-max(arr[])+1))
import java.util.*;
public class AllocateMinimumNumberOfPages {
    public static int countStudents(ArrayList<Integer> arr, int pages) {
        int n=arr.size();
        int stud=1, pageStudent=0;
        for (int i = 0; i < n; i++) {
            if (pageStudent + arr.get(i) <= pages) {
                pageStudent += arr.get(i);
            } else {
                stud++;
                pageStudent = arr.get(i);
            }
        }
        return stud;
    }
    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n)
            return -1;
        int low = Collections.max(arr);

        //summation of arraylist
        int high = arr.stream().mapToInt(Integer::intValue).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(arr, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
