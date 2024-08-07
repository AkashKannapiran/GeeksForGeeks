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
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    public class triplet{
        int r;
        int c;
        int step;
        
        triplet(int r, int c, int step) {
            this.r = r;
            this.c = c;
            this.step = step;
        }
    }
    
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        int kr = KnightPos[0];
        int kc = KnightPos[1];
        int tr = TargetPos[0];
        int tc = TargetPos[1];
        kr--;
        kc--;
        tr--;
        tc--;
        
        boolean visited[][] = new boolean[N][N];
        Queue<triplet> q = new ArrayDeque<>();
        
        q.add(new triplet(kr, kc, 0));
        
        visited[kr][kc] = true;
        int ans = 0;
        
        while (!q.isEmpty()) {
            triplet curr = q.poll();
            int x = curr.r;
            int y = curr.c;
            int s = curr.step;
            ans = Math.max(ans, s);
            
            if (tr == x && tc == y) {
                return ans;
            }
            
            if (x + 1 >= 0 && x + 1 < N && y + 2 >= 0 && y + 2 < N) {
                if (visited[x + 1][y + 2] == false) {
                    visited[x + 1][y + 2] = true;
                    q.add(new triplet(x + 1, y + 2, s + 1));
                }
            }
            
            if (x + 1 >= 0 && x + 1 < N && y - 2 >= 0 && y - 2 < N) {
                if (visited[x + 1][y - 2] == false) {
                    visited[x + 1][y - 2] = true;
                    q.add(new triplet(x + 1, y - 2, s + 1));
                }
            }
            if (x - 1 >= 0 && x - 1 < N && y + 2 >= 0 && y + 2 <N) {
                if (visited[x - 1][y + 2] == false) {
                    visited[x - 1][y + 2] = true;
                    q.add(new triplet(x - 1, y + 2, s + 1));
                }
            }
            
            if (x - 1 >= 0 && x - 1 < N && y - 2 >= 0 && y - 2 < N) {
                if (visited[x - 1][y - 2] == false) {
                    visited[x - 1][y - 2] = true;
                    q.add(new triplet(x - 1, y - 2, s + 1));
                }
            }
            
            if (x + 2 >= 0 && x + 2 < N && y + 1 >= 0 && y + 1 < N) {
                if (visited[x + 2][y + 1] == false) {
                    visited[x + 2][y + 1] = true;
                    q.add(new triplet(x + 2, y + 1, s + 1));
                }
            }
            
            if (x - 2 >= 0 && x - 2 < N && y + 1 >= 0 && y + 1 < N) {
                if (visited[x - 2][y + 1] == false) {
                    visited[x - 2][y + 1] = true;
                    q.add(new triplet(x - 2, y + 1, s + 1));
                }
            }
            
            if (x + 2 >= 0 && x + 2 < N && y - 1 >= 0 && y - 1 < N) {
                if (visited[x + 2][y - 1] == false) {
                    visited[x + 2][y - 1] = true;
                    q.add(new triplet(x + 2, y - 1, s + 1));
                }
            }
            
            if (x - 2 >= 0 && x - 2 < N && y - 1 >= 0 && y - 1 < N) {
                if (visited[x - 2][y - 1] == false) {
                    visited[x - 2][y - 1] = true;
                    q.add(new triplet(x - 2, y - 1, s + 1));
                }
            }
        }
        
        return -1;
    }
}