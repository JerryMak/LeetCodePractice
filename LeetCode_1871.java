/*
1871. Jump Game VII
You are given a 0-indexed binary string s and two integers minJump and maxJump. In the beginning, you are standing at index 0, which is equal to '0'. You can move from index i to index j if the following conditions are fulfilled:

i + minJump <= j <= min(i + maxJump, s.length - 1), and
s[j] == '0'.
Return true if you can reach index s.length - 1 in s, or false otherwise.
*/
// Attempt 1
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int target = s.length() - 1;
        int start;
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> toVisit = new Stack<Integer>();
        toVisit.push(0);
        while(!toVisit.empty()){
            start = toVisit.pop();
            for (int i = start + minJump; i <= start + maxJump && i <= target; i++){
                if (i > target){
                    return false;
                }
                if (s.charAt(i) == '0' && !visited.contains(i)){
                    if (i == target){
                        return true;
                    }
                    toVisit.push(i);
                }
            }
        }
        return false;
        
    }
}

// Attempt 2
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int target = s.length() - 1;
        int start;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Integer> toVisit = new PriorityQueue<Integer>();
        toVisit.add(0);
        while(toVisit.peek() != null){
            start = toVisit.poll();
            for (int i = Math.min(start + maxJump,target); i >= start + minJump; i--){
                if (i > target){
                    return false;
                }
                if (s.charAt(i) == '0' && !visited.contains(i)){
                    if (i == target){
                        return true;
                    }
                    toVisit.add(i);
                }
            }
        }
        return false;
        
    }
}

// Attempt 3
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int i = 0;
        int j = 1;
        boolean [] canReach = new boolean[s.length()];
        while (j < s.length()){
            if (j >= i + minJump && j <= i + maxJump && j < s.length() && s.charAt(j) == '0' ){
                canReach[j] = true;
            }
            if (j == i + maxJump){
                i++;
                while (!canReach[i] && i < s.length() - 1){
                    i++;
                }
            }
            j++;
            
        }
        return canReach[s.length() - 1];
        
    }
}