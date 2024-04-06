//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        Arrays.sort(arr);
		boolean triple = false;
		
		for (int i = 0; i < n - 2; i++) {
		    int temp = arr[i];
		    int l = i + 1;
		    int h = n - 1;
		    
		    while (l < h) {
		        int sum = temp + arr[l] + arr[h];
		        
		        if ((sum) == 0) {
		            triple = true;
		            break;
		        }
		        
		        if (sum > 0) {
		            h--;
		        }
		        else {
		            l++;
		        }
		    }
		}
		
		return triple;
    }
}