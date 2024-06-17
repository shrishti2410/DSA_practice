import java.util.Scanner;

class Node {
    int data;      // the data value
    Node next;      // the reference to the next Node in the linked list
    // Constructors
    Node(int data1, Node next1) {
        this.data = data1;  // Initialize data with the provided value
        this.next = next1;  // Initialize next with the provided reference
    }
    Node(int data1) {
        this.data = data1;  // Initialize data with the provided value
        this.next = null;   // Initialize next as null since it's the end of the list
    }
}
public class LinkedList {
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 7};
        // Creating a new Node with the value from the array
        Node y = new Node(arr[0]);
        // Printing the data stored in the Node
        System.out.println(y.data);
    }
}

//import java.util.Scanner;
//
//public class Solution {
//    public static Node constructLL(int[] arr) {
//        if (arr == null || arr.length == 0) {
//            return null; // Return null if the array is empty
//        }
//
//        Node head = new Node(arr[0]);
//        Node current = head;
//
//        for (int i = 1; i < arr.length; i++) {
//            Node newNode = new Node(arr[i]);
//            current.next = newNode;
//            current = newNode;
//        }
//
//        return head;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        int[] a = new int[t];
//        for (int i = 0; i < t; i++) {
//            a[i] = sc.nextInt();
//        }
//
//        // Create a linked list from the array
//        Node head = constructLL(a);
//
//        // Printing the linked list elements
//        printLinkedList(head);
//    }
//
//    private static void printLinkedList(Node head) {
//        while (head != null) {
//            System.out.print(head.data + " ");
//            head = head.next;
//        }
//    }
//}
