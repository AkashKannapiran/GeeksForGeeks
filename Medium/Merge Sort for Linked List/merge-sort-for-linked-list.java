//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        Node middle = findMiddle(head);
        Node secondHalf = middle.next;
        middle.next = null;
        Node firstHalfSorted = mergeSort(head);
        Node secondHalfSorted = mergeSort(secondHalf);
        
        return merge(firstHalfSorted, secondHalfSorted);
    }
    
    static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        
        while (fast.next != null && fast.next.next != null) {
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
                first = first.next;
            }
            else {
                tail.next = second;
                second = second.next;
            }
            
            tail = tail.next;
        }
        
        if (first != null) {
            tail.next = first;
        }
        else {
            tail.next = second;
        }
            
        return dummy.next;
    }
}


