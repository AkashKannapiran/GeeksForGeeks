//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int key) {
        data = key;
        next = prev = null;
    }
}

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                Node n1 = new Node(a);
                n1.prev = temp;
                temp.next = n1;
                temp = n1;
            }

            head = new Solution().sortDoubly(head);
            printList(head);
        }
    }

    public static void printList(Node node) {
        Node temp = node;
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/
class Solution {
    // Function to sort the given doubly linked list using Merge Sort.
    static Node sortDoubly(Node head) {
        // add your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        Node middle = findMiddle(head);
        Node secondHalf = middle.next;
        secondHalf.prev = null;
        middle.next = null;
        Node firstHalfSorted = sortDoubly(head);
        Node secondHalfSorted = sortDoubly(secondHalf);
        
        return merge(firstHalfSorted, secondHalfSorted);
    }
    
    static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    static Node merge(Node first, Node second) {
        Node dummy = new Node(0);
        Node tail = dummy;
        
        while (first != null && second != null) {
            if (first.data < second.data) {
                tail.next = first;
                first.prev = tail;
                first = first.next;
            }
            else {
                tail.next = second;
                second.prev = tail;
                second = second.next;
            }
            
            tail = tail.next;
        }
        
        if (first != null) {
            tail.next = first;
            first.prev = tail;
        }
        else {
            tail.next = second;
            second.prev = tail;
        }
        
        Node sortedHead = dummy.next;
        sortedHead.prev = null;
        
        return sortedHead;
    }
    
    
    
    
    
    
    
}