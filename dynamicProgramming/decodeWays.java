class Solution {
    Integer[] cache;
    char[] arr;
    public int numDecodings(String s) {
        this.arr = s.toCharArray();
        this.cache = new Integer[arr.length];
        
        return dfs(0);
    }
    
    public int dfs(int index){
        
        //if reach end, that path is valid
        if(index == arr.length){
            return 1;
        }
        
        if(cache[index] != null){
            return cache[index];
        }
        
        int total = 0 ;
        
        
        
        StringBuilder str = new StringBuilder();
        //consider every possible character in the string (first level)
        for(int i = index; i < arr.length && i < index + 2; i++){
            
            str.append(arr[i]);
            //consider adding next character to the string, if valid, consider the next character by itself
            //with its all possible paths (next levels)
            if(checkIfValid(str.toString())){
                total += dfs(i+1);
            }
        }
        
        //store result in cache so we don't have to recaculate.
        cache[index] = total;
        return total;
    }
    
    
    
    public boolean checkIfValid(String str){
        if(str.charAt(0) == '0'){
            return false;
        }
        
        int num = Integer.parseInt(str);
        
        return num < 27;
    }
    
}
