//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        int i = l;
        int j = r;
        int pivot = arr[l];
        
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            
            while (arr[j] > pivot) {
                j--;
            }
            
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                i++;
                j--;
            }
        }
        
        if (l + k - 1 <= j) {
            return kthSmallest(arr, l, j, k);
        }
        else if (l + k - 1 >= i) {
            return kthSmallest(arr, i, r, k - (i - l));
        }
        else {
            return arr[j + 1];
        }
    } 
}
