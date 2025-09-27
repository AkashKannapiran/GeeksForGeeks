class Solution {
    public void printNos(int n) {
        printNum(1, n);
    }
    
    public void printNum(int i, int n) {
        if (n == 0) {
            return;
        }
        
        System.out.print(i + " ");
        
        printNum(i + 1, n - 1);
    }
}
