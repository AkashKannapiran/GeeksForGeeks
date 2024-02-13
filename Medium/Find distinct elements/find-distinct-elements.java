//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int M[][] = new int[N][N];
            String arr[] = in.readLine().trim().split("\\s+");
            for(int i = 0;i < N*N; i++)
                M[i/N][i%N] = Integer.parseInt(arr[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.distinct(M, N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int distinct(int M[][], int N)
    {
        // code here
        if(N>M.length || N==1)
        {
            return 1;
        }
        int count=0;
        int actualCount=0;
        int rc=1;
        for(int i=0;i<M.length;i++)
        {
            count=0;
            rc=1;
            boolean isDistinct=true;
            for(int k=0;k<i;k++)
            {
                if(M[0][i]==M[0][k])
                {
                    isDistinct = false;
                    break;
                }
            }
            if(isDistinct==false)
            {
                continue;
            }
            for(int j=0;j<M[i].length;j++)
            {
                if(M[0][i]==M[rc][j])
                {
                    count++;
                    if((rc+1)<M.length)
                    {
                      rc++;
                      j=-1; 
                    }
                    else
                    {
                      break;
                    }
                }
            }
            if(count==M.length-1)
            {
                actualCount++;
            }
        }
        return actualCount;
    }
}