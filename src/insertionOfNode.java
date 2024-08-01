import java.util.*;
public class insertionOfNode {
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
    private static  Node insertionAtStart(Node head, int val){
        //insertion of head of a LL
        Node temp=new Node(val, head);
        return temp;
    }

    private static  Node insertionAtLast(Node head, int val){
        //insertion of head of a LL
        if (head == null)
            return new Node(val);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode=new Node(val);
        temp.next = newNode;
        return head;
    }


    private static Node insertionAtKthPosition(Node head, int val, int k) {
        //inserting element at kth place in a LL
        if (head == null) {
            if (k == 1)
                return new Node(val);
            else {
                return null;
            }
        }
        else{
            if (k == 1) {
                Node temp = new Node(val, head);
                return temp;
            }
            else{
                Node temp=head;
                int cnt=0;
                while(temp!=null){
                    cnt++;
                    if(cnt==k-1){
                        Node n=new Node(val);
                        n.next=temp.next;
                        temp.next=n;
                    }
                    else {
                        temp = temp.next;
                    }
                }
            }
            return head;
        }
    }
    private static Node insertionBeforeXthElement(Node head, int val, int k) {
        //inserting an element before an element 'x'
        //val=value to be inserted
        //k=element before which value should be inserted
        if (head == null) {
            return null;
        } else if (k==head.data) {
            Node temp = new Node(val, head);
            return temp;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                if(temp.next.data==k){
                    Node n=new Node(val, temp.next);
                    //n.next=temp.next;
                    temp.next=n;
                    break;
                }
                else {
                    temp = temp.next;
                }
            }
            return head;
        }
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
//        head=insertionAtStart(head, 7);
//        head=insertionAtLast(head, 7);
//        head=insertionAtKthPosition(head,20,2);
        head=insertionBeforeXthElement(head, 7 ,8);
        printLL(head);
    }
}


