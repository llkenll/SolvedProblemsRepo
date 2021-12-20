import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    HashMap<String, Boolean> cache= new HashMap<>();
    Set<String> dict;
    public boolean wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);

        return helper(s);
    }

    public boolean helper(String s){
        if(s == null || s.length() == 0){
            return true;
        }

        if(cache.containsKey(s)){
            return cache.get(s);
        }
        
        int n = s.length();
        for(int i = 0; i <= n; i++){
            String left = s.substring(0, i);
            String right = s.substring(i,n);
            //only start recursion if left substring is an element in the given dictionary
            if(dict.contains(left) && helper(right)){
                cache.put(s, true);
                return true;
            }                               
        }

        cache.put(s,false);
        return false;
    }
}