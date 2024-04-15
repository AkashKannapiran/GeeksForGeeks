//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Driverclass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().numOfWays(N, M));
        }
    }
}
// } Driver Code Ends


class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    static long numOfWays(int N, int M)
    {
        // add your code here
        long m = 1000000007;
        long total = 0;
        
        for (int i = 0;i < N; i++) {
            for (int j = 0; j < M; j++) {
                int c = attack(i, j, N, M);
                total += ((M * N) % m - (c + 1)) % m;
                total = total % m;
            }
        }
        
        return total;
    }
    
    static int attack(int i, int j, int r, int c) {
        
        int count = 0;
        int dx[] = {1, 2, 1, 2, -1, -2, -1, -2};
        int dy[] = {2, 1, -2, -1, 2, 1, -2, -1};
        
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            
            if (x >= 0 && y >= 0 && x < r && y < c) {
                count++;
            }
        }
        
        return count;
        
    }
}