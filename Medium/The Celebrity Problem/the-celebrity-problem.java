//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	int left = 0;
        int right = n - 1;
        
        while (left < right) {
            if (M[left][right] == 1) {
                left++;
            }
            else {
                right--;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (i != left && (M[i][left] == 0 || M[left][i] == 1)) {
                return -1;
            }
        }
        
        return left;
    }
}