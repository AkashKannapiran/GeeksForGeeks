//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
{
	public static void main (String[] args) throws IOException
	{
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 int tc=Integer.parseInt(br.readLine().trim());
	 
	 while(tc-- >0)
	 {
	     String line=br.readLine().trim();
	     
	     Solution obj = new Solution();
	     
	     System.out.println(obj.getMaxOccuringChar(line));
	     
	 }
	 }
}
// } Driver Code Ends



class Solution
{
    //Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String line)
    {
        // Your code here
        int[] freq = new int[26];
        
        for (char c : line.toCharArray()) {
            freq[c - 'a']++;
        }
        
        char maxChar = 'a';
        
        for (char c = 'b'; c <= 'z'; c++) {
            if (freq[c - 'a'] > freq[maxChar - 'a']) {
                maxChar = c;
            }
        }
        
        return maxChar;
    }
    
}