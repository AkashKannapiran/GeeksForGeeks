//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        int[] freqP = new int[256];
        int[] freqS = new int[256];
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIdx = 0;
        int start = 0;
        
        for (char c : p.toCharArray()) {
            freqP[c]++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            freqS[c]++;
            
            if (freqP[c] > 0 && freqS[c] <= freqP[c]) {
                count++;
            }
            
            if (count == p.length()) {
                while (freqS[s.charAt(start)] > freqP[s.charAt(start)] || freqP[s.charAt(start)] == 0) {
                    if (freqS[s.charAt(start)] > freqP[s.charAt(start)]) {
                        freqS[s.charAt(start)]--;
                    }
                    
                    start++;
                }
                
                int windowLen = i - start + 1;
                
                if (windowLen < minLen) {
                    minLen = windowLen;
                    startIdx = start;
                }
            }
        }
        
        if (minLen == Integer.MAX_VALUE) {
            return "-1";
        }
        
        return s.substring(startIdx, startIdx + minLen);
    }
}