//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> st = new Stack<Integer>();
        boolean[] visited = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                DFS(i, adj, st, visited);
            }
        }
        
        ArrayList<ArrayList<Integer>> rev = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < V; i++) {
            rev.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < V; i++) {
            for (int u : adj.get(i)) {
                rev.get(u).add(i);
            }
        }
        
        int count = 0;
        Arrays.fill(visited, false);
        
        while (!st.isEmpty()) {
            int u = st.pop();
            Queue<Integer> q = new ArrayDeque<>();
            
            if (visited[u] == false) {
                count++;
                q.add(u);
                visited[u] = true;
            }
            
            while (!q.isEmpty()) {
                int v = q.poll();
                
                for (int a : rev.get(v)) {
                    if (visited[a] == false) {
                        visited[a] = true;
                        q.add(a);
                    }
                }
            }
        }
        
        return count;
    }
    
    void DFS(int s, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, boolean[] visited) {
        visited[s] = true;
        
        for (int u : adj.get(s)) {
            if (visited[u] == false) {
                DFS(u, adj, st, visited);
            }
        }
        
        st.push(s);
    }
}
