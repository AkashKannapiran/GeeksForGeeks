//{ Driver Code Starts
// Initial Template for Java
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
            ArrayList<ArrayList<Integer>> ptr = ob.tarjans(V, adj);

            for(int i=0; i<ptr.size(); i++)
            {
                for(int j=0; j<ptr.get(i).size(); j++)
                {
                    if(j==ptr.get(i).size()-1)
                        System.out.print(ptr.get(i).get(j));
                    else
                        System.out.print(ptr.get(i).get(j) + " ");
                }
                System.out.print(",");
            }
            System.out.println();
		}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int time;
    
    void DFS(int s, ArrayList<ArrayList<Integer>> adj, int[] low, int[] disc, boolean[] stackmem, Stack<Integer> st, ArrayList<ArrayList<Integer>> res) {
        stackmem[s] = true;
        low[s] = disc[s] = ++time;
        st.push(s);
        
        for (int u : adj.get(s)) {
            if (disc[u] == -1) {
                DFS(u, adj, low, disc, stackmem, st, res);
                low[s]=Math.min(low[u],low[s]);
            }
            else if (stackmem[u]) {
                low[s] = Math.min(low[s], disc[u]);
            }
        }
        
        int w = -1;
        
        if (low[s] == disc[s]) {
                ArrayList<Integer> temp = new ArrayList<>();
                
                while (w != s) {
                    w = st.pop();
                    stackmem[w] = false;
                    temp.add(w);
                }
                
                Collections.sort(temp);
                res.add(temp);
        }
    }
    
    //Function to return a list of lists of integers denoting the members 
    //of strongly connected components in the given graph.  
    public ArrayList<ArrayList<Integer>> tarjans(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // code here
        Stack<Integer> st=new Stack<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int[] low = new int[V];
        int[] disc = new int[V];
        Arrays.fill(disc, -1);
        boolean[] stackmem = new boolean[V];
        time = 0;
        
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                DFS(i, adj, low, disc, stackmem, st, res);
            }
        }
    
        Collections.sort(res, (a, b) -> a.get(0) - b.get(0));
        
        return res;
    }
}