//Brute force-Count total nodes, subtract n from it, traverse again and delete it
//TC=O(len)+O(len-N)=O(2*len)
//SC=O(1)

//Optimal-Take 2 pointers, fast n slow
//TC=O(len)
//SC=O(1)

import java.util.*;
public class RemovingNthNodeFromBehind {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 2, 0, 1, 0, 2};
        //N=2
        //{1, 0, 1, 2, 0, 1, 2}
        Node head = convert2LL(arr);
        head=remNthNodeFromBehind(head,2);
        print(head);
    }
    private static Node remNthNodeFromBehind(Node head, int n){
        Node fast=head;
        Node slow=head;
        for(int i=0; i<n; i++){
            fast=fast.next;
        }
        if(fast==null){
            return head.next;
        } else {
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            //Node delNode=slow.next;
            slow.next = slow.next.next;
            return head;
        }
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
    private static void print(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
}
