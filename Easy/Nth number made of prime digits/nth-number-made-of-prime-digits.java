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
		  Solution ob = new Solution();
		  System.out.println(ob.primeDigits(n));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find nth number made of only prime digits.
    public static int primeDigits(int n)
    {
        //Your code here
        int count = 0;
        int num = 2;
        
        while (count < n) {
            if (containsOnlyPrimes(num)) {
                count++;
            }
            
            num++;
        }
        
        return num - 1;
    }
    
    public static boolean containsOnlyPrimes(int num) {
        
        String numStr = Integer.toString(num);
        
        for (char c : numStr.toCharArray()) {
            int digit = c - '0';
            
            if (digit != 2 && digit != 3 && digit != 5 && digit != 7) {
                return false;
            }
        }
        
        return true;
    }
}