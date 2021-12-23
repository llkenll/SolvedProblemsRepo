class Solution {
    int[][] cache;
    public int change(int amount, int[] coins) {
        cache = new int[coins.length][amount+1];
        return helper(coins, amount);

    }

    public int helper(int[] coins, int amount){
        cache[0][0] = 1;
        //build the first row from previous calculated values

        for(int col = 1; col <= amount; col++){
            int remainingAmount = col - coins[0];
            if(remainingAmount < 0){
                continue;
            }
            cache[0][col] = cache[0][remainingAmount];
        }

        //build the remaining rows
        for(int row = 1; row < coins.length; row++){
             //0 always has one combination
             cache[row][0] = 1;
            for(int col = 1; col <= amount; col++){
               int prevCalc = cache[row-1][col];

               int currentCalc = 0;
               if(col-coins[row] >= 0){
                   int diff = col-coins[row];
                   currentCalc = cache[row][diff];
               }

               int total = currentCalc+prevCalc;
               cache[row][col] = total;
                
            }
        }

        return cache[coins.length-1][amount];
    }
        
}