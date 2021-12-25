import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {

        int[] subArray = Arrays.copyOfRange(nums, 0, nums.length-2);
        int first = robHelper(subArray);
        subArray = Arrays.copyOfRange(nums, 1, nums.length-1);
        int last = robHelper(subArray);

        return Math.max(first, last);
    }
    
    
    public int robHelper(int[] nums){
        int a = 0;
        int b = 0;
        
        for(int i = 0; i < nums.length; i++){
            int temp = Math.max(a+nums[i], b);
            a = b;
            b = temp;
        }
        
        return b;
    }
}
