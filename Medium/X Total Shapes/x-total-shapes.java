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
            char[][] grid = new char[n][m];
            for(int i = 0; i < n; i++){
                String S = br.readLine().trim();
                for(int j = 0; j < m; j++){
                    grid[i][j] = S.charAt(j);
                }
            }
            Solution obj = new Solution();
            int ans = obj.xShape(grid);
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
    //Function to find the number of 'X' total shapes.
    public int xShape(char[][] grid)
    {
        // code here
        Queue<pair> q = new ArrayDeque<>();
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int count = 0;
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 'X' && visited[i][j] == false) {
                    count++;
                    q.add(new pair(i, j));
                    visited[i][j] = true;
                    
                    while (!q.isEmpty()) {
                        pair curr = q.poll();
                        int r1 = curr.r;
                        int c1 = curr.c;
                        
                        for (int k = 0; k < 4; k++) {
                            int x = r1 + dx[k];
                            int y = c1 + dy[k];
                            
                            if (x >= 0 && x < r) {
                                if (y >= 0 && y < c) {
                                    if (grid[x][y] == 'X' && visited[x][y] == false) {
                                        visited[x][y] = true;
                                        q.add(new pair(x, y));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return count;
    }
}