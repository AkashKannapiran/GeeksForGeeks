//{ Driver Code Starts

// } Driver Code Ends

//Back-end complete function Template for Java
import java.util.*;

public class Main {
    public static void main(String args[]) {
        // Your Code Here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int multiplier = 10;
        
        while (multiplier > 0) {
            System.out.print(n * multiplier-- + " ");
        }
    }
}



//{ Driver Code Starts.
// } Driver Code Ends