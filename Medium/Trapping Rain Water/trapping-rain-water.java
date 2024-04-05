//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
        long left = 1;
        long right = n - 2;
        long leftMax = arr[0];
        long rightMax = arr[n - 1];
        long trappedWater = 0;
        
        while (left <= right) {
            if (leftMax >= rightMax) {
                if (arr[(int)right] <= rightMax) {
                    trappedWater += rightMax - arr[(int)right];
                    right--;
                }
                else {
                    rightMax = arr[(int)right];
                    right -= 1;
                }
            }
            else {
                if (arr[(int)left] <= leftMax) {
                    trappedWater += leftMax - arr[(int)left];
                    left++;
                }
                else {
                    leftMax = arr[(int)left];
                    left += 1;
                }
            }
        }
        
        return trappedWater;
    } 
}


