class Solution {
    Integer[][] cache;
    int m;
    int n;
    public int uniquePaths(int m, int n) {
        cache = new Integer[m][n];
        this.m = m;
        this.n = n;
        return dfs(0,0);
       
    }
    
    
    public int dfs(int row, int col){
        if(row >= m || col >= n){
            return 0;
        }
        
        if(row == m-1 && col == n-1){
            return 1;
        }
        
        if(cache[row][col] != null){
            return cache[row][col];
        }
        
        int right = dfs(row, col+1);
        int down = dfs(row+1, col);
        int total = right+down;
        
        cache[row][col] = total;
    
        return cache[row][col];
    }
    
    
}