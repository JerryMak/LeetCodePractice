/*
45. Jump Game II
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.
*/

class Solution {
    public int jump(int[] nums) {
        int target = nums.length - 1;
        int i;
        int skip;  
        int steps = 0;
        while (target > 0){
            skip = 1;
            steps += 1;
            i = target - 1;
            while (i >= 0){
                if (nums[i] >= skip){
                    target = i;
                }
                skip += 1;
                i -= 1;
            }             
        }
        return steps;   
    }
}