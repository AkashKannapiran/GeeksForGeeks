class Solution {
    static void printTillN(int N) {
        printNum(1, N);        
    }
    
    static void printNum(int i, int N) {
        if (N == 0) {
            return;
        }
        
        System.out.print(i + " ");
        
        printNum(i + 1, N - 1);
    }
}