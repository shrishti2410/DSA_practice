//TC=O(N)

import java.util.*;
public class LemonadeChange {
    public static void main(String[] args) {
        int b[]={5,5,5,10,20};
        System.out.println(Solution.lemonadeChange(b));
    }
    class Solution {
        public static boolean lemonadeChange(int[] bills) {
            int five=0, ten=0;
            for(int i=0; i< bills.length; i++){
                if(bills[i]==5){
                    five++;
                } else if (bills[i]==10 && five>0){
                    five--;
                    ten++;
                } else if (bills[i]==20 && five>0 && ten>0) {
                    five--;
                    ten--;
                } else if (bills[i]==20 && five>2) {
                    five=five-3;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}