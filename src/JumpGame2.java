//TC=O(N)
//SC=O(1)

////Brute force
//public class JumpGame2 {
//    public static void main(String[] args) {
//        int n[]={3,2,1,8,4};
//        System.out.println(Solution.canJump(n));
//    }
//    class Solution {
//        public static boolean canJump(int[] nums) {
//            int maxIndex=0;
//            for (int i=0; i< nums.length-1; i++){
//                if(i>maxIndex){
//                    return false;
//                }
//                maxIndex=Math.max(maxIndex, i+nums[i]);
//            }
//            return maxIndex >= nums.length - 1;
//        }
//
//        public static boolean f(int ind, int jumps) {
//            if(ind>=n-1){
//                return jumps;
//            }
//            int mini=
//        }
//    }
//}
//

//public class JumpGame2 {
//    public static void main(String[] args) {
//        int n[]={3,2,1,8,4};
//        System.out.println(Solution.canJump(n));
//    }
//    class Solution {
//        public static boolean canJump(int[] nums) {
//            int maxIndex=0;
//            for (int i=0; i< nums.length-1; i++){
//                if(i>maxIndex){
//                    return false;
//                }
//                maxIndex=Math.max(maxIndex, i+nums[i]);
//            }
//            return maxIndex >= nums.length - 1;
//        }
//    }
//}
