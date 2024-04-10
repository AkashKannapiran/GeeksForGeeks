//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    String s=sc.nextLine();
		    
		    System.out.println(printNumber(s,s.length()));
		}
		
	}

// } Driver Code Ends
//User function Template for Java


//Function to find matching decimal representation of a string as on the keypad.
public static String printNumber(String s, int n) 
{
    //Your code here
    HashMap<Character, Integer> map = new HashMap<>();
    map.put('a', 2);
    map.put('b', 2);
    map.put('c', 2);
    map.put('d', 3);
    map.put('e', 3);
    map.put('f', 3);
    map.put('g', 4);
    map.put('h', 4);
    map.put('i', 4);
    map.put('j', 5);
    map.put('k', 5);
    map.put('l', 5);
    map.put('m', 6);
    map.put('n', 6);
    map.put('o', 6);
    map.put('p', 7);
    map.put('q', 7);
    map.put('r', 7);
    map.put('s', 7);
    map.put('t', 8);
    map.put('u', 8);
    map.put('v', 8);
    map.put('w', 9);
    map.put('x', 9);
    map.put('y', 9);
    map.put('z', 9);
    
    StringBuilder result = new StringBuilder();
    
    for (int i = 0; i < n; i++) {
        result.append(map.get(s.charAt(i)));
    }
    
    return result.toString();
}

//{ Driver Code Starts.

}

// } Driver Code Ends