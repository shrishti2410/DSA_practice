//Brute force-Reach (n/2)th node
//TC-O(N+N/2)
//SC-O(1)

//Optimal-Tortoise and hare algo-Skip one step of slow
//TC-O(N/2)
//SC-O(1)

public class DeleteMiddleNode {
    private static Node DelMid(Node head){
        if (head == null || head.next==null) {
            return null;
        }
        Node slow=head, fast=head;
        fast=fast.next.next;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
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
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,3,2,1};
        Node head = convert2LL(arr);
        head=DelMid(head);
    }
}



