import java.util.*;
public class ReverseDLL {
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

    private static Node1 revDLL(Node1 head){
        if(head==null|| head.next==null){
            return head;
        } else {
            Node1 curr = head;
            Node1 prev=null;
            while (curr!=null){
                prev=curr.back;
                curr.back=curr.next;
                curr.next=prev;

                curr=curr.back;
            }
            return prev.back;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 7, 9 ,11};
        // Creating a new Node with the value from the array
        Node1 head = convert2DLL(arr);
        head=revDLL(head);
        print(head);
    }
}
