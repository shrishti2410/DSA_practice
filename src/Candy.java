//Brute force-Create 2 arrays, by taking lust left and just right and then form another array taking the max of both
//TC=O(3N)
//SC=O(2N)

//Optimal-Slope approach
//TC=O(N)
//SC=O(1)

import java.util.*;
public class Candy {
    public static void main(String[] args) {

    }

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // Initialize left and right arrays with 1s
        for (int i = 0; i < n; i++) {
            left[i] = 1;
            right[i] = 1;
        }

        // Traverse from left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        // Calculate the total number of candies
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(left[i], right[i]);
        }

        return sum;
    }
    public int candy1(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int peak=1, sum=1, i=1;
        while(i<ratings.length) {
            if (ratings[i] == ratings[i + 1]) {
                sum = sum + 1;
                i++;
            }
            while (i < ratings.length && ratings[i] > ratings[i + 1]) {
                peak++;
                sum = sum + peak;
                i++;
            }
            int down = 1;
            while (i < ratings.length && ratings[i] < ratings[i - 1]) {
                sum = sum + down;
                i++;
                down++;
            }
            if (down > peak) {
                sum = sum + down - peak;
            }
        }
        return sum;
    }
    public int candy2(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int n = ratings.length;
        int totalCandies = 1;
        int up = 1, down = 0, peak = 1;

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                up++;
                peak = up;
                down = 0;
                totalCandies += up;
            } else if (ratings[i] < ratings[i - 1]) {
                down++;
                up = 1;
                totalCandies += down;
                if (down >= peak) {
                    totalCandies++;
                }
            } else {
                up = 1;
                down = 0;
                peak = 1;
                totalCandies++;
            }
        }

        return totalCandies;
    }
}