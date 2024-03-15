//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.ListIterator;
class GFG {
	public static void main (String[] args) {
		
		//Taking input using class Scanner
		Scanner sc = new Scanner(System.in);
		
		//Taking count of total number of testcases
		int t = sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		  
		  
		  //Taking the string as input
		  String str=sc.nextLine();
		  Solution ob = new Solution();
		  //Calling the unique_substring method
		  //and printing the result
		  System.out.println(ob.unique_substring(str));
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{

        public static int unique_substring(String str)
    {
        //Your code here
        Set<String> uniqueSubstrings = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                uniqueSubstrings.add(str.substring(i, j));
            }
        }
        return uniqueSubstrings.size();
    }
}