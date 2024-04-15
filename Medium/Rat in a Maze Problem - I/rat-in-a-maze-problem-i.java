//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    static final int[][] dir = {{0, -1, 'L'}, {-1, 0, 'U'}, {0, 1, 'R'}, {1 ,0, 'D'}};
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> result = new  ArrayList<>();
        
        findPath(m, result, new StringBuilder(), 0, 0, n);
        
        return result;
    }
    
    static void findPath(int[][] m, ArrayList<String> result, StringBuilder s, int i, int j, int n) {
        if (i == n || j == n || j < 0 || i < 0) {
            return;
        }
        
        if (i == n - 1 && j == n - 1 && m[i][j] == 1) {
            result.add(s.toString());
            
            return;
        }
        
        if (m[i][j] == 0) {
            return;
        }
        
        for (int[] d : dir) {
            m[i][j] = 0;
            s.append((char) d[2]);
            findPath(m, result, s, i + d[0], j + d[1], n);
            s.deleteCharAt(s.length() - 1);
            m[i][j] = 1;
        }
        
    }
}