//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        
        // Your code here
        int maxNormal = normalMaxSum(a, n);
        
        if (maxNormal < 0) {
            return maxNormal;
        }
        
        int arrSum = 0;
        
        for (int i = 0; i < n; i++) {
            arrSum += a[i];
            a[i] =- a[i];
        }
        
        int maxCircular = arrSum + normalMaxSum(a, n);
        
        return Math.max(maxCircular, maxNormal);
    }
    
    static int normalMaxSum(int a[], int n) {
        int res = a[0];
        int maxEnd = a[0];
        
        for (int i = 1; i < n; i++) {
            maxEnd = Math.max(maxEnd + a[i], a[i]);
            res = Math.max(res, maxEnd);
        }
        
        return res;
    }
    
}

