/*
2217. Find Palindrome With Fixed Length
Given an integer array queries and a positive integer intLength, return an array answer where answer[i] is either the queries[i]th smallest positive palindrome of length intLength or -1 if no such palindrome exists.

A palindrome is a number that reads the same backwards and forwards. Palindromes cannot have leading zeros.
*/
// Attempt 1
class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int start = (int) Math.pow(10, intLength - 1);
        int end = (int) Math.pow(10, intLength) - 1;
        int halfFront = (int) Math.pow(10,(int) Math.ceil((double)intLength / 2));
        int halfBack = (int) Math.pow(10,(int) intLength / 2);
        int back;
        int front;
        HashMap<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
        int k = 0;
        long [] results = new long [queries.length];
        for (int i = start; i <= end; i++){
            back = i % halfBack;
            front = reverse(i / halfFront);
            if (front == back ){
                k++;
                valueMap.put(k,i);
            } 
        }       
        for (int j = 0; j < queries.length; j++){
            if (valueMap.containsKey(queries[j])){
                results[j] = valueMap.get(queries[j]);
            } else {
                results[j] = -1;
            }
        }    
        return results;    
    }
       
    public int reverse(int x) {
        int result = 0;
        while (x > 0){
            result = (result * 10) + (x % 10);
            x = x / 10;
        }
        return result;
    }
}

// Attempt 2
class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long halfFront = (long)Math.pow(10, (long)Math.ceil((long)intLength / 2));
        long start;
        long end;
        long val;
        int k = 0;
        HashMap<Integer, Long> valueMap = new HashMap<Integer, Long>();
        long [] results = new long [queries.length];
        if (intLength % 2 == 0){
            start = halfFront / 10;   
            end = halfFront - 1;
        } else {
            start = halfFront;   
            end = halfFront * 10 - 1;
        }
        
        for (long i = start; i <= end; i++){
            k++;
            valueMap.put(k,i); 
        }       
        for (int j = 0; j < queries.length; j++){
            if (valueMap.containsKey(queries[j])){
                val = valueMap.get(queries[j]);
                if (intLength % 2 == 0){
                    results[j] = val*halfFront + reverse(val);
                }else{
                    results[j] = val*halfFront + reverse(val/10);
                }
            } else {
                results[j] = -1;
            }
        }    
        return results;    
    }
       
    public long reverse(long x) {
        long result = 0;
        while (x > 0){
            result = (result * 10) + (x % 10);
            x = (long)Math.floor(x / 10);
        }
        return result;
    }
}

// Attempt 3
class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long val;
        long [] results = new long [queries.length];

        int halfLen = (int) Math.ceil((double)intLength / 2);
        long halfFront = (long)Math.pow(10, halfLen);
        long start = halfFront / 10;  
        long end = halfFront - 1;

        for (int j = 0; j < queries.length; j++){
            System.out.println(queries[j] + ":" + end);
            if (queries[j] <= end - start + 1){
                val = start + queries[j] - 1;
                if (intLength % 2 == 0){
                    results[j] = val*halfFront + reverse(val);
                }else{
                    results[j] = (val*halfFront)/10 + reverse(val/10);
                }
            } else {
                results[j] = -1;
            }
        }    
        return results;    
    }
       
    public long reverse(long x) {
        long result = 0;
        while (x > 0){
            result = (result * 10) + (x % 10);
            x = (long)Math.floor(x / 10);
        }
        return result;
    }
}