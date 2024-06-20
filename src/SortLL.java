//Brute force-take counter and then replace the data
//TC=O(2N)
//SC=O(1)

//Optimal-Create 3 m=nodes of zeros, ones, twos and then join them
//TC=O(N)
//SC=O(1)

import java.util.*;
public class SortLL {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 2, 0, 1, 0, 2};
        //{0,0,0,1,1,1,2,2}
        Node head = convert2LL(arr);
        head=sort(head);
        print(head);
    }
    private static Node sort(Node head){
        if(head==null || head.next==null)
            return head;
        else {
            Node zeroHead = new Node(-1);
            Node oneHead = new Node(-1);
            Node twoHead = new Node(-1);
            Node zero = zeroHead;
            Node one=oneHead;
            Node two=twoHead;

            Node temp = head;
            while (temp != null) {
                if (temp.data == 0) {
                    zero.next = temp;
                    zero=temp;
                } else if (temp.data == 1) {
                    one.next = temp;
                    one=temp;
                } else {
                    two.next = temp;
                    two=temp;
                }
                temp = temp.next;
            }

            if(oneHead.next!=null){
                zero.next=oneHead.next;
            } else {
                zero.next=twoHead.next;
            }

            one.next=twoHead.next;
            two.next=null;
            Node newHead=zeroHead.next;

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
