//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for(int t=0;t<testCases;t++){
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++){
		        arr[i] = sc.nextInt();
		    }
		    Arrays.sort(arr);
		    ArrayList <ArrayList<Integer>> res = new solve().AllSubsets(arr,n);
		    for (int i = 0; i < res.size (); i++)
		    {
		        System.out.print ("(");
		        for (int j = 0; j < res.get(i).size (); j++)
		        {
		            if (j != res.get(i).size()-1)
		                System.out.print ((res.get(i)).get(j) + " ");
		            else
		                System.out.print ((res.get(i)).get(j));
		        }
		        System.out.print (")");
		      
		    }
		    System.out.println();
		}
	}
}
// } Driver Code Ends

class comp implements Comparator<ArrayList<Integer>> {
    public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
            
            int n = Math.min(a.size(), b.size());
            
            for (int i = 0; i < n; i++) {
                if (a.get(i) != b.get(i)) {
                    return a.get(i) - b.get(i);
                }
            }
            
            return a.size() - b.size();
            
        }
    }
    
class solve
{
    static ArrayList<ArrayList<Integer>> res;
    //Function to find all possible unique subsets.
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        // your code here
        Arrays.sort(arr);
        res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        subset(arr, curr, 0);
        
        Collections.sort(res, new comp());
        
        return res;
    }
    
    public static void subset(int[] arr, ArrayList<Integer> curr, int i) {
        
        if (i == arr.length) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < curr.size(); j++) {
                temp.add(curr.get(j));
            }
            
            res.add(temp);
            
            return;
        }
        
        curr.add(arr[i]);
        subset(arr, curr, i + 1);
        
        while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
            i++;
        }
        
        curr.remove(curr.size() - 1);
        subset(arr, curr, i + 1);
        
    }
}
