import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        //sort, remove duplicate, add to hashtable

        
        ArrayList<Integer> tempArr = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++){
            if(!tempArr.contains(nums[i])){
                tempArr.add(nums[i]);
            }
        }

        Integer[] arr = (Integer[]) tempArr.toArray();
        
        Arrays.sort(arr);

        Map<Integer, Integer> repeatedCount = new HashMap<Integer, Integer>();

      

        
        for(int i = 0; i < nums.length; i++){
           int count = countDuplicate(nums[i], nums, i);
            repeatedCount.put(nums[i], count);
           
        }
        int earn1 = 0;
        int earn2 = 0;
        for(int i = 0; i < nums.length; i++){
            int curren = nums[i] *  repeatedCount.get(nums[i]);
            if(i != 0 && nums[i] == nums[i-1]){
               int temp = earn2;
               earn2 = Math.max(curren+earn1, earn2);
               earn1 = temp;
            
            }else{
                int temp = earn2;
                earn2 = curren+earn2;
                earn1 = temp;
                
            }

        }

        return earn2;
    }


    public int countDuplicate(int target, int[] arr, int currentIndex){
        int count = 0;
        for(int i = currentIndex; i < arr.length; i++){
            if(target != arr[i]){
               return count;
            }else{
                count++;
            }
        }
        return count;
    }
}