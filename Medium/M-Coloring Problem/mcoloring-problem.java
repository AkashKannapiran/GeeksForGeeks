//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        if(m==1 && n>1){
            return false;
        }
        
        int V=graph.length;
        int[] vertices=new int[V];
        boolean[] visited=new boolean[V];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(graph[i][j]){
                    adj.get(i).add(j);
                }
            }
        }
        
        Arrays.fill(vertices,-1);
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                if(!graphColor(i,adj,m,vertices,visited)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    boolean graphColor(int s,ArrayList<ArrayList<Integer>> adj,int m,
                       int[] vertices,boolean[] visited){
        
        visited[s]=true;
        int i=0;
        while(i<m){
            vertices[s]=i;
            int k=i;
            for(int u:adj.get(s)){
                if(vertices[u]==vertices[s]){
                    i++;
                    break;
                }
            }
            if(i==k){
                for(int u:adj.get(s)){
                    if(!visited[u]){
                        boolean b=graphColor(u,adj,m,vertices,visited);
                        if(b==false){
                            vertices[u]=-1;
                            visited[u]=false;
                            i++;
                            break;
                        }
                    }
                }
                
                if(i==k){
                    return true;
                }
            }
        }
        return false;
        
    }
}