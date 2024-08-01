import java.util.*;
public class removalOfNode {
    private static Node a2LL(int[] arr){
        //converting an array to LL
        Node head=new Node(arr[0]);
        Node mover=head;
        for(int i=1; i<arr.length; i++){
            Node temp=new Node(arr[i]);
            mover.next=temp;
            mover=temp;
        }
        return head;
    }
    private static  Node removalOfHead(Node head){
        //removal of head of a LL
        if(head==null){
            return head;
        }
        head=head.next;
        return head;
    }
    private static Node deleteTail(Node head) {
        //removal of tail of a LL
        if (head == null || head.next == null)
            return null;
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    private static Node deleteParticularEle(Node head, int k) {
        //removing kth element of a LL
        if (head == null || head.next == null)
            return null;
        Node temp = head;
        if(k==1){
            head=head.next;
            return head;
        }

        int i=2;
        while(temp!=null){
            if(i==k){
                temp.next = temp.next.next;
            }
            temp = temp.next;
            i++;
        }
        return head;
    }

    private static Node deleteParticularVal(Node head, int val) {
        //removing a particular value from a LL
        if (head == null)
            return null;

        if(head.data==val){
            head=head.next;
            return head;
        }

        Node temp = head;
        Node prev = null;
        while(temp!=null){
            if(temp.data==val){
                prev.next = prev.next.next;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static void printLL(Node head) {
        //printing a LL
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int[] arr={12, 5, 8};
        Node head=a2LL(arr);
        //head=removalOfHead(head);
        //head=deleteTail(head);
        //head=deleteParticularEle(head, 1);
        head=deleteParticularVal(head, 5);
        printLL(head);
    }
}


