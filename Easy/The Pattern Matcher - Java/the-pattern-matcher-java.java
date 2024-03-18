//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    
	public static void main (String[] args)
	{
	     //Taking input using Scanner class
    	 Scanner sc = new Scanner(System.in);
    	 
    	 //taking count of total testcases
    	 int t = sc.nextInt();
    	 
    	 boolean flag = false;
    	 while(t-- > 0){
    	   
    	   //taking the String
    	   String s=sc.next();
    	   
    	   Geeks obj=new Geeks();
    	   
    	   //calling follPatt() method
    	   //of class Geeks and passing
    	   //String as parameter
    	   obj.follPatt(s);
    	   
    	 }
    }
}


// } Driver Code Ends
//User function Template for Java



class Geeks{
    
    static void follPatt(String s)
    {
        
        //Your code here
        int count = 0;
        boolean flag = true;
        
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == 'x'){
                if (flag && count !=0){
                    break;
                }
                else{
                    flag = false;
                    count ++;
                }
            }
            else{
                flag = true;
                count --;
            }
            
        }
        if (count != 0){
             System.out.println(0);   
        }
        else{
            System.out.println(1);
        }
    }
}


//{ Driver Code Starts.

// } Driver Code Ends