//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    class pair {
        int r;
        int c;
        
        pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        // Code here
        Queue<pair> q = new ArrayDeque<>();
        int r = grid.length;
        int c = grid[0].length;
        boolean visited[][] = new boolean[r][c];
        int res = 0;
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {-0, 0, 1, -1, -1, 1, -1, 1};
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    q.add(new pair(i, j));
                    visited[i][j] = true;
                    int count = 0;
                    
                    while (!q.isEmpty()) {
                        count++;
                        pair curr = q.poll();
                        int r1 = curr.r;
                        int c1 = curr.c;
                        
                        for (int a = 0; a < 8; a++) {
                            int x = r1 + dx[a];
                            int y = c1 + dy[a];
                            
                            if (x >= 0 && y >= 0 && x < r && y < c) {
                                if (grid[x][y] == 1 && visited[x][y] == false) {
                                    q.add(new pair(x, y));
                                    visited[x][y] = true;
                                }
                            }
                        }
                    }
                    res = Math.max(res, count);
                }
            }
        }
        
        return res;
    }
}