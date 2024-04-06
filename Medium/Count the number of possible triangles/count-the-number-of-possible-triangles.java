//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        while(t > 0)
        {
            //taking elements count
            int n = sc.nextInt();
            
            //creating an array of length n
            int arr[] = new int[n];
            
            //adding elements to the array
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            
            //creating an object of class Solutions
            Solution ob = new Solution();
            
            //calling the method findNumberOfTriangles()
            //of class Solutions and printing the results
            System.out.println(ob.findNumberOfTriangles(arr,n));
            t--;
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution
{
    //Function to count the number of possible triangles.
    static int findNumberOfTriangles(int arr[], int n)
    {
        // code here
        int triangles = 0;
        Arrays.sort(arr);
        
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            triangles += greaterSum(curr, i - 1, arr);
        }
        
        return triangles;
    }
    
    static int greaterSum(int compare, int end, int[] arr) {
        int start = 0;
        int count = 0;
        
        while (start < end) {
            if ((arr[start] + arr[end]) > compare) {
                count += end - start;
                end--;
            }
            else {
                start++;
            }
        }
        
        return count;
    }
}