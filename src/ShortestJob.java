//TC=O(N+NlogN)

import java.util.*;
public class ShortestJob {
    public static void main(String[] args) {
        int b[] = {4, 3, 7, 1, 2};
        System.out.println(Solution.solve(b));
    }

    class Solution {
        public static int solve(int bt[]) {
            Arrays.sort(bt);
            int t=0, wt=0;
            for (int i=0; i<bt.length-1; i++){
                t=t+bt[i];
                wt=wt+t;
            }
            return wt/bt.length;
        }
    }
}