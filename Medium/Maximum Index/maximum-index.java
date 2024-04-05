//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}
// } Driver Code Ends


class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) { 
        
        // Your code here
        // if (n == 1) {
        //     return 0;
        // }
        // int res = a[1] - a[0];
        // int minValue = a[0];
        // int index = 0;
        
        // for (int i = 0; i < n; i++) {
        //     if (a[i] - minValue > res) {
        //         res = a[i] - minValue;
        //         index = i;
        //     }
            
        //     minValue = Math.min(minValue, a[i]);
        // }
        
        // return index + 1;
        
        if (n == 1) {
            return 0;
        }
        
        int rightMax[] = new int[n];
        int leftMin[] = new int[n];
        
        leftMin[0] = a[0];
        
        for (int i = 1; i < n; ++i) {
            leftMin[i] = Integer.min(a[i], leftMin[i - 1]);
        }
        
        rightMax[n - 1] = a[n - 1];
        
        for (int j = n - 2; j >= 0; --j) {
            rightMax[j] = Integer.max(a[j], rightMax[j + 1]);
        }
        
        int i = 0;
        int j = 0;
        int maxDiff = -1;
        
        while (j < n && i < n) {
            if (leftMin[i] <= rightMax[j]) {
                maxDiff = Integer.max(maxDiff, j - i);
                j++;
            }
            else {
                i++;
            }
        }
        
        return maxDiff;
    }
}


