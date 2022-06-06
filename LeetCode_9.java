/*
9. Palindrome Number
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward.

For example, 121 is a palindrome while 123 is not.
*/
class Solution {
    public boolean isPalindrome(int x) {
        int result = 0;
        int y = x;
        if (x < 0){
            return false;
        }
        while (y > 0){
            result = (result * 10) + (y % 10);
            y = y / 10;
        }
        return x == result;
    }
}