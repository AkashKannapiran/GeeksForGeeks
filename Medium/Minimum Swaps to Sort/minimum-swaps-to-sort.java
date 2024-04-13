//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        Map<Integer, Integer> h = new HashMap<>();
        int ans = 0;
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);
        Arrays.sort(temp);
        
        for (int i = 0; i < n; i++) {
            h.put(nums[i], i);
        }
        
        int init = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] != temp[i]) {
                ans++;
                init = nums[i];
                
                int tempIndex = h.get(temp[i]);
                nums[i] = nums[tempIndex];
                nums[tempIndex] = init;
                
                h.put(init, tempIndex);
                h.put(temp[i], i);
            }
        }
        
        return ans;
    }
}