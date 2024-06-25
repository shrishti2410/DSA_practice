//Brute force-rev the LL n add 1 to the head, take a carry to keep a track of carry over
//TC=O(3N)-rev,traversal,rev
//SC=O(1)

//Optimal-Backtracking(recursion)
//TC-O(N)
//SC-O(N)

////Brute force
//import java.util.*;
//public class Add1ToLL {
//    public static void main(String[] args) {
//        int[] arr = {1,2,9,9};
//        //{1,3,0,0}
//        Node head = convert2LL(arr);
//        head=Add(head);
//        print(head);
//    }
//    private static Node Add(Node head){
//        head=revLL(head);
//        Node temp= head;
//        int carry=1;
//        while(temp!=null){
//            temp.data= temp.data+carry;
//            if(temp.data<10){
//                carry=0;
//                break;
//            } else {
//                temp.data=0;
//                carry=1;
//            }
//            temp=temp.next;
//        }
//        if(carry==1){
//            Node newNode=new Node(1);
//            head=revLL(head);
//            newNode.next=head;
//            return newNode;
//        } else {
//            head=revLL(head);
//            return head;
//        }
//    }
//    private static Node convert2LL(int arr[]){
//        if (arr.length == 0) return null;
//        Node head=new Node(arr[0]);
//        Node mover=head;
//        for(int i=1; i<arr.length; i++){
//            Node temp=new Node(arr[i]);
//            mover.next=temp;
//            mover=temp;
//        }
//        return head;
//    }
//    private static Node revLL(Node head){
//        Node temp=head, prev=null, front;
//        if(head==null || head.next==null){
//            return head;
//        } else {
//            while (temp!=null){
//                front=temp.next;
//                temp.next=prev;
//                prev=temp;
//                temp=front;
//            }
//            return prev;
//        }
//    }
//    private static void print(Node head){
//        while(head!=null){
//            System.out.print(head.data+" ");
//            head=head.next;
//        }
//        System.out.println();
//    }
//}

//Optimal(Backtracking)
import java.util.*;
public class Add1ToLL {
    public static void main(String[] args) {
        int[] arr = {1,2,9,9};
        //{1,3,0,0}
        Node head = convert2LL(arr);
        head=Add(head);
        print(head);
    }
    private static Node Add(Node head){
        int carry=helper(head);
        if(carry==1){
            Node newNode=new Node(1);
            newNode.next=head;
            return newNode;
        } else {
            return head;
        }
    }
    static int helper(Node temp){
        if(temp==null){
            return 1;
        } else {
            int carry=helper(temp.next);
            temp.data=temp.data+carry;
            if(temp.data<10){
                return 0;
            } else {
                temp.data=0;
                return 1;
            }
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
