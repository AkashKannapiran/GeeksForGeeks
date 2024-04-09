//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
        //Your code here
        Set<Character> set = new HashSet<>();
        
        if (S.length() == 1) {
            return S.charAt(0);
        }
        
        for (int i = 0; i < S.length(); i++) {
            String str = S.substring(i + 1, S.length());
            
            if (!str.contains(String.valueOf(S.charAt(i))) && !set.contains(S.charAt(i))) {
                return S.charAt(i);
            }
            
            set.add(S.charAt(i));
        }
        
        return '$';
    }
}

