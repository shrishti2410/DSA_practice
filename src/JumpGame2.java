//Brute force-Recursion

//Optimal
//TC=O(N)
//SC=O(1)

public class JumpGame2 {
    public static void main(String[] args) {
        int n[]={3,2,1,8,4};
        System.out.println(canJump(n));
    }
    public static int canJump(int[] nums) {
        int jumps=0, l=0, r=0, n=nums.length;
        while (r<n-1){
            int farthest=0;
            for(int i=l; i<=r; i++){
                farthest=Math.max(i+nums[i], farthest);
            }
            l=r+1;
            r=farthest;
            jumps=jumps+1;
        }
        return jumps;
    }
}