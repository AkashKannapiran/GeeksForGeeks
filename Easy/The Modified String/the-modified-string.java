//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            String a = "";
            a = sc.next();
            System.out.println(new Solution().modified(a));
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find minimum number of characters which Ishaan must insert  
    //such that string doesn't have three consecutive same characters.
    public static long modified(String a)
    {
        // Your code here
        long length = 1;
        long count = 0;
        
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) == a.charAt(i - 1)) {
                length++;
                
                if (length == 3) {
                    count++;
                    length -= 2;
                }
            }
            else {
                length = 1;
            }
        }
        
        return count;
    }
}