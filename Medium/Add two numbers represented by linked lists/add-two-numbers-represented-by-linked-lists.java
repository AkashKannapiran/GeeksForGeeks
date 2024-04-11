//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node num1 = new Node(val);
            Node tail = num1;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node num2 = new Node(val);
            tail = num2;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2){
        // code here
        // return head of sum list
        Node dummyHead = new Node(-1);
        Node resultTail = dummyHead;
        Node reversedNum1 = reverse(num1);
        Node reversedNum2 = reverse(num2);
        int carry = 0;
        
        while(reversedNum1 != null || reversedNum2 != null || carry != 0) {
            int sum = carry;
            
            if(reversedNum1 != null) {
                sum += reversedNum1.data;
                reversedNum1 = reversedNum1.next;
            }
            
            if(reversedNum2 != null) {
                sum += reversedNum2.data;
                reversedNum2 = reversedNum2.next;
            }
            
            carry = sum / 10;
            int digit = sum % 10;
            
            Node newNode = new Node(digit);
            resultTail.next = newNode;
            resultTail = resultTail.next;
        }
        
        Node resultHead = reverse(dummyHead.next);
        
        while (resultHead != null && resultHead.data == 0 && resultHead.next != null) {
            resultHead = resultHead.next;
        }
        
        return resultHead;
    }
    
    static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        
        while(current != null){
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}