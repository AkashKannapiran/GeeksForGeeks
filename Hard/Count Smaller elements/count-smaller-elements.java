//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    int[] constructLowerArray(int[] arr, int n) {
        // code here
        int[] result = new int[n];
        int[] indexArray = new int[n];
       
        for (int i = 0; i < n; i++) {
            indexArray[i] = i;
        }
       
        mergeSort(arr, indexArray, result, 0, n - 1);
       
        return result;
    }
   
    void mergeSort(int[] arr, int[] indexArray, int[] result, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
           
            mergeSort(arr, indexArray, result, low, mid);
            mergeSort(arr, indexArray, result, mid + 1, high);
           
            merge(arr, indexArray, result, low, mid, high);
        }
    }
   
    void merge(int[] arr, int[] indexArray, int[] result, int low, int mid, int high) {
        int[] tempIndexArray = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        int inversionCount = 0;
       
        while (i <= mid && j <= high) {
            if (arr[indexArray[i]] > arr[indexArray[j]]) {
                tempIndexArray[k++] = indexArray[j++];
                inversionCount++;
            } else {
                result[indexArray[i]] += inversionCount;
                tempIndexArray[k++] = indexArray[i++];
            }
        }
       
        while (i <= mid) {
            result[indexArray[i]] += inversionCount;
            tempIndexArray[k++] = indexArray[i++];
        }
       
        while (j <= high) {
            tempIndexArray[k++] = indexArray[j++];
        }
       
        for (int p = 0; p < k; p++) {
            indexArray[low + p] = tempIndexArray[p];
        }
    }
}