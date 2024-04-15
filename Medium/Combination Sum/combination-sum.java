//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        // add your code here
        Collections.sort(A);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(A.get(0));
        
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) == A.get(i - 1)) {
                continue;
            }
            else {
                arr.add(A.get(i));
            }
        }
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        sums(arr, B, 0, a, res);
        
        return res;
    }
    
    static void sums(ArrayList<Integer> arr, int sum, int given, ArrayList<Integer> g, ArrayList<ArrayList<Integer>> res) {
        
        if (given == sum) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < g.size(); i++) {
                temp.add(g.get(i));
            }
            
            res.add(temp);
            
            return;
        }
        
        if (given + arr.get(0) > sum) {
            return;
        }
        
        int j = 0;
        
        if (g.size() > 0) {
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) == g.get(g.size() - 1)) {
                    j = i;
                    break;
                }
            }
        }
        
        for (int i = j; i < arr.size(); i++) {
            if (sum - given < arr.get(i)) {
                break;
            }
            else {
                g.add(arr.get(i));
                sums(arr, sum, given + arr.get(i), g, res);
                g.remove(Integer.valueOf(arr.get(i)));
            }
        }
    }
}