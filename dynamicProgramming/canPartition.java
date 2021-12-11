public boolean canPartition(int[] nums) {
        
        //if sum is even, proceed
        int total = 0;
        for(int i = 0 ; i <  nums.length; i++){
            total+=nums[i];
        }
        
        if(total%2 != 0){
            return false;
        }else{
            return canPartition(nums, total, 0, 0, new HashMap<String, Boolean>());
        }
    }
    
    
    public boolean canPartition(int[] nums, int total, int indx, int sum, HashMap<String, Boolean> cache){
        
        //memoization
        String current = indx + " "+ sum;
        
        if(indx >= nums.length || sum > total/2){
            return false;
        }
        
        if(sum == total/2){
            return true;
        }
        
        if(cache.containsKey(current)){
            return cache.get(current);
        }
        //can either take the current number or ignore it and go on to the next
        boolean result = canPartition(nums, total, indx+1, sum, cache) || canPartition(nums, total, indx+1, sum+nums[indx], cache);
        
        cache.put(current, result);
        
        return result;
        
    }
