//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                  matrix[i][j] =sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.determinantOfMatrix(matrix, n));
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function for finding determinant of matrix.
    static int determinantOfMatrix(int matrix[][], int n)
    {
        // code here 
        if (n == 1) {
            return matrix[0][0];
        }
        
        int determinant = 0;
        int sign = 1;
        
        for (int i = 0; i < n; i++) {
            int[][] submatrix = new int[n - 1][n - 1];
            
            getCofactor(matrix, submatrix, 0, i, n);
            
            determinant += sign * matrix[0][i] * determinantOfMatrix(submatrix, n - 1);
            sign =- sign;
        }
        
        return determinant;
    }
    
    static void getCofactor(int mat[][], int submat[][], int r, int c, int n){
        
        int i=0;
        int j=0;
        
        for (int row = 0; row < n; row++) {
            for (int col = 0;col < n; col++) {
                if (row != r && col != c) {
                    submat[i][j++] = mat[row][col];
                    
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
}

