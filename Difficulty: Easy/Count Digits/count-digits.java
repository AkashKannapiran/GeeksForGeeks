//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.evenlyDivides(N));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int evenlyDivides(int n) {
        int num = n;
        int count = 0;
        
        while (num > 0) {
            int digit = num % 10;
            
            if (digit == 0) {
                num /= 10;
                continue;
            }
            
            if (n % digit == 0) {
                count++;
            }
            
            num /= 10;
        }
        
        return count;
    }
}