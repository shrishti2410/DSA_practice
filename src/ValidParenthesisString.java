import java.util.*;
public class ValidParenthesisString {
    public static void main(String[] args) {

    }

    //Brute force-recursion
    //TC=O(3^N)
    //SC=O(N)
    public boolean checkValidString(String s) {
        return checkValidString(s, 0, 0);
    }
    private boolean checkValidString(String s, int index, int balance) {
        // Base case: If balance is negative, we have more ')' than '('
        if (balance < 0) {
            return false;
        }

        // Base case: If we have reached the end of the string
        if (index == s.length()) {
            return balance == 0;
        }

        char c = s.charAt(index);

        // Recur based on the current character
        if (c == '(') {
            return checkValidString(s, index + 1, balance + 1);
        } else if (c == ')') {
            return checkValidString(s, index + 1, balance - 1);
        } else { // c == '*'
            // Try all three possibilities for '*'
            return checkValidString(s, index + 1, balance + 1) || // treat '*' as '('
                    checkValidString(s, index + 1, balance - 1) || // treat '*' as ')'
                    checkValidString(s, index + 1, balance);       // treat '*' as empty
        }
    }

    //Better-DP(Memoization)
    //TC=O(N^2)
    //SC=O(N^2)

    //Optimal-
    //TC=O(N)
    //SC=O(1)
    public boolean checkValidString1(String s) {
        int min = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                min++;
                max++;
            } else if (s.charAt(i) == ')') {
                min--;
                max--;
            } else {
                min--;
                max++;
            }
            if (min < 0) {
                min = 0;
            }
            if (max < 0) {
                return false;
            }
        }
        return min == 0;
    }
}
