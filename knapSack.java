package CompetitiveProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class knapsack {

	public static void main(String[] args) {
		
		class ItemValue {
	        Double cost;
	        double wt, val, ind;
	  
	        // item value function
	        public ItemValue(int wt, int val, int ind)
	        {
	            this.wt = wt;
	            this.val = val;
	            this.ind = ind;
	            cost = new Double((double)val / (double)wt);
	        }
	    }
		
		Scanner obj = new Scanner(System.in);
		

			
		while(obj.hasNext()) {
			String[] beginInput = new String[2];
			beginInput = obj.nextLine().split(" ");
			if(!obj.hasNextLine()) {
				break;
			}
			int capacity = Integer.parseInt(beginInput[0]);
			int numOfCases = Integer.parseInt(beginInput[1]);
			
			ItemValue[] IV = new ItemValue[numOfCases];
			
			
			ArrayList<Integer> indices = new ArrayList<Integer>();
			for(int j = 0; j < numOfCases; j++) {
				String[] data =  obj.nextLine().split(" ");
				int value  = Integer.parseInt(data[0]);
				int weight = Integer.parseInt(data[1]);
				ItemValue nIV = new ItemValue(weight, value,j);
		
				IV[j] = nIV;
			}
			
			Arrays.sort(IV, new Comparator<ItemValue>() {
	            @Override
	            public int compare(ItemValue o1, ItemValue o2)
	            {
	                return o2.cost.compareTo(o1.cost);
	            }
	        });
			
			int index = 0;
			while(true) {
				int indice = (int) IV[index].ind;
				int weight = (int) IV[index].wt;
				capacity = capacity - weight;
				
				
				if(capacity >= 0) {
					indices.add(indice);
				}
				
				if (capacity <= 0 || indices.size() == IV.length) {
					break;
				}
				
				index++;
			}
			
			Collections.sort(indices);
			
			System.out.println(indices.size());
			
			for(int x = 0; x < indices.size(); x++) {
				System.out.print(indices.get(x));
				
				if(x != indices.size()-1) {
					System.out.print(" ");
				}else {
					System.out.println("");
				}
				
				
			}
			
			
			
		}
		
			
			
}
}


		
		
		




