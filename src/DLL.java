import java.util.Scanner;
class Node1 {
    int data;
    Node1 next;
    Node1 back;
    Node1(int data1, Node1 next1, Node1 back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }
    Node1(int data1) {
        this.data = data1;
        this.next = null;
        this.back = null;
    }
}


public class DLL {
    private static void print(Node1 head){
        while(head!=null){
            System.out.println(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
    private static Node1 convert2DLL(int[] arr){
        Node1 head=new Node1(arr[0]);
        Node1 prev=head;
        for(int i=1; i<arr.length; i++){
            Node1 temp=new Node1(arr[i], null,prev);
            prev.next=temp;
            prev=temp;
        }
        return head;
    }

    private static Node1 deleteKthEle(Node1 head, int k) {
        //removing kth element of a LL
        if (head == null)
            return null;
        Node1 temp = head;
        int cnt=0;
        while(temp!=null){
            cnt++;
            if(cnt==k){
                break;
            }
            temp=temp.next;
        }
        Node1 prev=temp.back;
        Node1 front=temp.next;

        if(prev==null && front==null){
            return null;
        } else if (prev==null) {
            temp.next=null;
            front.back=null;
            return head;
        } else if (front==null) {
            prev.next=null;
            temp.back = null;
            return head;
        } else{
            prev.next=front;
            front.back=prev;
            temp.next=null;
            temp.back=null;
            return head;
        }
    }

    private static Node1 insertBeforeHead(Node1 head, int val){
        //insert before head
        Node1 newHead= new Node1(val,head,null);
        return newHead;
    }

    private static Node1 insertBeforeTail(Node1 head, int val){
        //insert before tail
        if(head.next==null){
            return insertBeforeHead(head, val);
        }
        Node1 tail= head;
        while (tail.next!=null){
            tail=tail.next;
        }
        Node1 prev=tail.back;
        Node1 temp= new Node1(val, tail, prev);
        prev.next=temp;
        tail.back=temp;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 7, 9 ,11};
        // Creating a new Node with the value from the array
        Node1 head = convert2DLL(arr);
        // Printing the data stored in the Node
        head = insertBeforeTail(head,12);
        // Printing the updated DLL
        print(head);
    }
}

