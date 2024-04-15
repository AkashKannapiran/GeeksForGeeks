//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int k = sc.nextInt();
                    String str = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.findMaximumNum(str, k));
                }
        }
}
// } Driver Code Ends




class Solution{
    
    static String ans;
    //Function to find the largest number after k swaps.
    static void bigBoy(String res,int counter,int pos){
       
        if(res.compareTo(ans)>0){
            ans=res;
        }
        
        if(counter>0){
            int n=res.length();
            for(int i=pos;i<n;i++){
               for(int j=i+1;j<n;j++){
                   if(res.charAt(j)>res.charAt(i)){
                       bigBoy( swap(res,i,j) , counter-1 , i+1 );
                   }
               }
            }
        }
        
    }
    
    static String swap(String str, int i, int j){
        
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
        
    }
    
    public static String findMaximumNum(String str, int k){
        
        ans=str;
        String res=new String(str);
        bigBoy(res,k,0);
        
        return ans;
        
    }
    
}