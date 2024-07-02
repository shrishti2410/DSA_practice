//TC=O(N)
//SC=O(N)-recursive stack space

import java.util.*;
public class RevLL_Recursive {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        //{4,3,2,1}
        Node head = convert2LL(arr);
        head=revLL(head);
        print(head);
    }

    private static Node revLL(Node head){
        if(head==null || head.next==null) {
            return head;
        } else {
            Node newHead=revLL(head.next);
            Node front=head.next;
            front.next=head;
            head.next=null;
            return newHead;
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
