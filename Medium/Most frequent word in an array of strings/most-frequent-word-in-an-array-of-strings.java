//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main(String[] args) throws IOException{
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    sc.nextLine();
		    Solution obj = new Solution();
		    String arr[]=sc.nextLine().split(" ");
		    System.out.println(obj.mostFrequentWord(arr, n));
		    
		}
	}
}

// } Driver Code Ends
//User function Template for Java


class Solution
{
    //Function to find most frequent word in an array of strings.
    public String mostFrequentWord(String arr[],int n)
    {
        // code here
        HashMap<String,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            if(mp.containsKey(arr[i])){
                mp.put(arr[i],mp.get(arr[i])+1);
            }
            else{
                mp.put(arr[i],1);
            }
        }
        
        String res="";
        int max=0;
        HashSet<String> s=new HashSet<>();
        for(int i=0;i<n;i++){
            if(max<mp.get(arr[i])){
                res=arr[i];
                s.add(arr[i]);
                max=mp.get(arr[i]);
            }
            else if(max==mp.get(arr[i]) && s.contains(arr[i])==false){
                res=arr[i];
                s.add(arr[i]);
            }
        }
        
        return res;
    }

}


//{ Driver Code Starts.
// } Driver Code Ends