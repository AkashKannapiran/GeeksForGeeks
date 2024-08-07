//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayDeque<Integer> mq = new ArrayDeque<>();
        List<Integer> ts = new ArrayList<>();
        int[] inDegree = new int[V];
        
        for (int i = 0; i < inDegree.length; i++) {
            for (int j : adj.get(i)) {
                inDegree[j]++;
            }
        }
        
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                mq.add(i);
            }
        }
        
        while (mq.size() != 0) {
            int rem = mq.remove();
            ts.add(rem);
            
            for (int i : adj.get(rem)) {
                inDegree[i]--;
                
                if (inDegree[i] == 0) {
                    mq.add(i);
                }
            }
        }
        
        return ts.size() == V ? false : true;
    }
}