import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    Set<String> wordDict;
    
    Map<String, List<String>> cache = new HashMap<>();
    
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = new HashSet<>(wordDict);
        return DFS(s);
    }
    
    public List<String> DFS(String s){
        if(cache.containsKey(s)){
            return cache.get(s);
        }
        
        List<String> res = new LinkedList<>();
        if(s.length() == 0){
            res.add("");
            return res;
        }
        for(String word: wordDict){
            if(s.startsWith(word)){
                String temp = s.substring(word.length());
                List<String> sublist = DFS(temp);
                for(String obj: sublist){
                    res.add(word + (obj.isEmpty() ? "":" ")+obj);
                }
            }
        }
        
        cache.put(s, res);
        return res;
        
    }
}