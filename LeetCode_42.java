/*
42. Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
*/
// Attempt 1: O(n)
class Solution {
    public int trap(int[] height) {
        int [] highestLeft = new int [height.length];
        int [] highestRight = new int [height.length];
        int leftMax = 0;
        int rightMax = 0;
        int amt = 0;
        
        int i = 1;
        int j = height.length - 2;
        highestLeft[0] = 0;
        highestRight[height.length - 1] = 0;
        while (i < height.length){
            if (height[i-1] > leftMax){
                leftMax = height[i-1];
            }
            highestLeft[i] = leftMax;
            
            if (height[j+1] > rightMax){
                rightMax = height[j+1];
            }
            highestRight[j] = rightMax;
            
            i++;
            j--;
        }
        
        for (int k = 0; k < height.length; k++){
            if (Math.min(highestLeft[k],highestRight[k]) > height[k]){
                amt = amt + Math.min(highestLeft[k],highestRight[k]) - height[k];
            }
        }
             
        return amt;

    }
}