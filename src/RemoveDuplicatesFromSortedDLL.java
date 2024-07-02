//Brute force-Nested loop
//TC=O(N)
//SC=O(1)

import java.util.ArrayList;

public class RemoveDuplicatesFromSortedDLL {
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
    private static Node1 removeDuplicates(Node1 head){
        Node1 temp=head;
        while (temp.next!=null){
            Node1 nextNode=temp.next;
            while (nextNode!=null && nextNode.data==temp.data) {
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if(nextNode!= null) {
                nextNode.back = temp;
            }
            temp=temp.next;
        }
        return head;
    }
    private static void printDLL(Node1 head) {
        Node1 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr={1,1,1,2,3,3,3,4,9};
        Node1 head=convert2DLL(arr);
        head=removeDuplicates(head);
        printDLL(head);
    }
}
