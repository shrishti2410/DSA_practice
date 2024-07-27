//Optimal-binary search
//TC=O(N * log (base 2) (Max element of array)
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMaxPile(piles);

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEatAllBananas(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int getMaxPile(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    private boolean canEatAllBananas(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k; // equivalent to Math.ceil(pile / k)
            if (hours > h) {
                return false;
            }
        }
        return true;
    }
}
