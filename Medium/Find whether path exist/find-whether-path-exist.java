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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            boolean ans = obj.is_Possible(grid);
            if(ans)
                System.out.println("1");
            else 
                System.out.println("0");
        }
    }
}
// } Driver Code Ends



class Solution
{
    class triplet {
        int ch;
        int r;
        int c;
        
        triplet(int ch, int r, int c) {
            this.c = ch;
            this.r = r;
            this.c = c;
        }
    }
    
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        Queue<triplet> q = new ArrayDeque<>();
        int r = grid.length;
        int c = grid[0].length;
        
        boolean visited[][] = new boolean[r][c];
        
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    
                    q.add(new triplet(grid[i][j], i, j));
                    
                    while (!q.isEmpty()) {
                        triplet curr = q.poll();
                        
                        int r1 = curr.r;
                        int c1 = curr.c;
                        
                        for (int k = 0; k < 4; k++) {
                            int x = r1 + dx[k];
                            int y = c1 + dy[k];
                            
                            if (x >= 0 && x < r) {
                                if (y >= 0 && y < c) {
                                    if (grid[x][y] == 2) {
                                        return true;
                                    }
                                    else if (visited[x][y] == false && grid[x][y] == 3) {
                                        visited[x][y] = true;
                                        
                                        q.add(new triplet(grid[x][y], x, y));
                                    }
                                }
                            }
                        }
                    }
                    
                    return false;
                }
            }
        }
        
        return false;
    }
}