/*
1. Two Sum
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsHash = new HashMap<>();
        int[] out = {-1,-1}; 
        for (int i = 0; i < nums.length; i++){
            if (numsHash.containsKey(target - nums[i])){
                out[0] = numsHash.get(target - nums[i]);
                out[1] = i;   
                return out;
            } else {
                numsHash.put(nums[i],i);
            }
        } 
        return out;
        
    }
}