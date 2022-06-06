/*
5. Longest Palindromic Substring

Given a string s, return the longest palindromic substring in s.
*/
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++){
            int len1 = distanceFromCenter(s,i,i);
            int len2 = distanceFromCenter(s,i,i+1);
            int len = Math.max(len1, len2);
            System.out.println(len);
            if (len > end - start){
                start = i - (len - 1)/2;
                end = i + len/2; 
            }
        }
        return s.substring(start,end + 1);
    }
    
    public int distanceFromCenter(String s, int left, int right){
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r - l - 1;
    }
}