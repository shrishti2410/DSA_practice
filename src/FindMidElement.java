//Brute force-mid=(len/2)+1
//TC=O(N+N/2)
//SC=O(1)

//Optimal-Tortoise n hare algorithm(slow n fast pointers)
//slow pointer moves by 1 step and fast pointer moves by 2 steps
//TC=
//SC=

import java.util.*;
public class FindMidElement {
    public static void main(String[] args) {
        int[] arr = {1,2,9,9};
        //9
        Node head = convert2LL(arr);
        head=FindMid(head);
        System.out.println(head.data);
    }
    private static Node FindMid(Node head){
        if (head == null) {
            return null;
        }
        Node slow=head, fast=head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private static Node convert2LL(int arr[]){
        if (arr.length == 0) return null;
        Node head=new Node(arr[0]);
        Node mover=head;
        for(int i=1; i<arr.length; i++){
            Node temp=new Node(arr[i]);
            mover.next=temp;
            mover=temp;
        }
        return head;
    }
}
