//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int x = Integer.parseInt(inputLine[1]);
		    
		    List<Integer> arr = new ArrayList<>();
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr.add(Integer.parseInt(inputLine[i]));
		    }
		    new Solution().sortABS(arr,n, x);
		    StringBuilder sb = new StringBuilder();
		    for(int y : arr)
		        sb.append(y+ " ");
		    System.out.println(sb.toString());
		    
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to sort the array according to difference with given number.
    static void sortABS(List<Integer> arr, int n, int k)  
    {
        // add your code here
        mergeSort(arr, 0, n - 1, k);
    }
    
    static void mergeSort(List<Integer> arr, int l, int r, int sub) {
        if (l < r) {
            int m = (l + r) / 2;
            
            mergeSort(arr, l, m, sub);
            mergeSort(arr, m + 1, r, sub);
            merge(arr, l, m, r, sub);
        }
    }
    
    
    static void merge(List<Integer> arr, int l, int m, int r, int sub) {
        
        int[] left = new int[m - l + 1];
        int[] right = new int[r - m];
        
        for (int i = 0; i <= left.length - 1; i++) {
            left[i] = arr.get(l + i);
        }
        
        for (int i = 0; i <= right.length - 1; i++) {
            right[i] = arr.get(i + m + 1);
        }
        
        int i = 0;
        int j = 0;
        int k = l;
        
        while (i <= left.length - 1 && j <= right.length - 1) {
            if (Math.abs(left[i] - sub) <= Math.abs(right[j] - sub)) {
                arr.set(k, left[i]);
                i++;
                k++;
            }
            else {
                arr.set(k, right[j]);
                j++;
                k++;
            }
        }
        
        while (i <= left.length - 1) {
          arr.set(k, left[i]);
          i++;
          k++;
        }
        
        while (j <= right.length - 1) {
          arr.set(k, right[j]);
          j++;
          k++;
        }
        
    }
}
