//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class CountSort
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            String arr = "";
            arr = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.countSort(arr));
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to arrange all letters of a string in lexicographical 
    //order using Counting Sort.
    public static String countSort(String arr)
    {
        // code here
        int[] count = new int[26];
        
        for (int i=0; i<arr.length(); i++){
            char ch = arr.charAt(i);
            count[ch-'a']++;
        }
        
        StringBuilder sorted = new StringBuilder();
        for (int i=0; i<26; i++){
            char ch = (char)('a'+i);
            while (count[i]-- > 0){
                sorted.append(ch);
            }
        }
        
        return sorted.toString();
    }
}