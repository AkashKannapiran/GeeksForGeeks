//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        if (N < M) {
            return -1;
        }
        
        int start = A[0];
        int end = 0;
        
        for (int a : A) {
            end += a;
        }
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (canAllocate(A, N, M, mid)) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        
        return start;
    }
    
    public static boolean canAllocate(int[]A, int books, int student, int pages) {
        int studentCount=1;
        int pageCount=0;
        
        for (int i = 0; i < books; i++) {
            if (A[i] > pages) {
                return false;
            }
            
            if (pageCount + A[i] > pages) {
                studentCount++;
                pageCount = A[i];
            }
            else {
                pageCount += A[i];
            }
        }
        
        return studentCount <= student;
    }
};