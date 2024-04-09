//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.lang.*;
import java.io.*;
class Driverclass
 {
	public static void main (String[] args) {
	   
	   Scanner in = new Scanner(System.in);
	   int t= in.nextInt();
	   while(t-->0){
	       
	       int n = in.nextInt();
	       int [] arr= new int[n];
	       for(int i=0;i<n;i++) {
	           arr[i] = in.nextInt();
	       }
	       System.out.println(new Solution().countSubarrWithEqualZeroAndOne(arr, n));
	   }
	 }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        // add your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int countZeros = 0;
        int countOnes = 0;
        int totalCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                countZeros++;
            }
            else {
                countOnes++;
            }
            
            int diff = countZeros - countOnes;
            
            if (diff == 0) {
                totalCount++;
            }
            
            if (map.containsKey(diff)) {
                totalCount += map.get(diff);
            }
            
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        
        return totalCount;
    }
}


