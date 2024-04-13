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
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int[] ans = obj.articulationPoints(V, adj);
            for(int i: ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    int time;
    int count;
    
    public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int[] disc = new int[V];
        boolean[] visited = new boolean[V];
        int[] low = new int[V];
        boolean[] ap = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        
        time = 0;
        count = 0;
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(i, adj, disc, parent, low, visited, ap);
            }
        }
        
        if (count == 0) {
            int[] res = {-1};
            return res;
        }
        
        int[] res = new int[count];
        int index = 0;
        
        for (int i = 0; i < V; i++) {
            if(ap[i]) {
                res[index++] = i;
            }
        }
        
        return res;
    }
    
    void DFS(int s, ArrayList<ArrayList<Integer>> adj, int[] disc, int[] parent, int[] low, boolean[] visited, boolean[] ap) {
        
        visited[s] = true;
        int children = 0;
        low[s] = ++time;
        disc[s] = time;
        
        for (int u : adj.get(s)) {
            if (visited[u] == false) {
                children++;
                parent[u] = s;
                
                DFS(u, adj, disc, parent, low, visited, ap);
                
                low[s] = Math.min(low[u], low[s]);
                
                if (parent[s] == -1 && children > 1 && !ap[s]) {
                    ap[s] = true;
                    count++;
                }
                else if (parent[s] != -1 && low[u] >= disc[s] && !ap[s]) {
                    ap[s] = true;
                    count++;
                }
            }
            else if (u != parent[s]) {
                low[s] = Math.min(low[s], disc[u]);
            }
        }
    }
}