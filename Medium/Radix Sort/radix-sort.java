//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String str[] = read.readLine().trim().split(" ");
            
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
                
            Solution obj = new Solution();
            obj.radixSort(arr, n);
            for(int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
                
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution
{

    static void radixSort(int arr[], int n) 
    {
        // code here 
        int max=0;
        
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        
        for(int exp=1;max/exp>0;exp*=10){
            countSort(arr,n,exp,max);
        }
    }

    static void countSort(int arr[],int n,int exp,int max){
        
        int[] count=new int[1000000];
        int[] out=new int[n];
        
        for(int i=0;i<1000000;i++){
            count[i]=0;
        }
        
        for(int i=0;i<n;i++){
            count[(arr[i]/exp)%10]++;
        }
        
        for(int i=1;i<1000000;i++){
            count[i]=count[i-1]+count[i];
        }
        
        for(int i=n-1;i>=0;i--){
            out[count[(arr[i]/exp)%10]-1]=arr[i];
            count[(arr[i]/exp)%10]--;
        }
        
        for(int i=0;i<n;i++){
            arr[i]=out[i];
        }
    }
}

