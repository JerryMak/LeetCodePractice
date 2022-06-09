/*
11. Container With Most Water
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.
*/
// Attempt 1 - O(n^2)
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int tmp;
        for (int i = 0; i < height.length; i++){
            for (int j = i + 1; j < height.length; j++){
                tmp = Math.min(height[i],height[j]) * (j - i);
                if (max < tmp){
                    max = tmp;
                }
            }
        }
        return max;
    }
}

// Attempt 2 - O(n)
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int tmp;
        int l = 0;
        int r = height.length - 1;
        while (l < r ){
            tmp = Math.min(height[r], height[l]) * (r - l);
            if (tmp > max){
                max = tmp;
            }
            if (height[r] > height[l]){
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}