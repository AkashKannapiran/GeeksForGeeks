//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
        // Your code here
        char[] chars = str.toCharArray();
        int n = chars.length;
        char[] lowerCase = new char[n];
        char[] upperCase = new char[n];
        int lowerIndex = 0;
        int upperIndex = 0;
        
        for (char ch : chars) {
            if (Character.isLowerCase(ch)) {
                lowerCase[lowerIndex++] = ch;
            }
            else {
                upperCase[upperIndex++] = ch;
            }
        }
        
        Arrays.sort(lowerCase, 0, lowerIndex);
        Arrays.sort(upperCase, 0, upperIndex);
        
        StringBuilder result = new StringBuilder();
        int lowerPointer = 0, upperPointer = 0;
        
        for (int i = 0; i < n; i++) {
            if (Character.isLowerCase(chars[i])) {
                result.append(lowerCase[lowerPointer++]);
            }
            else {
                result.append(upperCase[upperPointer++]);
            }
        }
        
        return result.toString();
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    PrintWriter out=new PrintWriter(System.out);
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        out.println(sortedStr);
    	    }
    	    out.close();
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
// } Driver Code Ends