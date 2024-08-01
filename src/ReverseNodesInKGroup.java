//Brute force-Find first k nodes, point the last one to null(so that it breaks into a new LL of k nodes)(preserve the next node before breaking the link), perform reversal. Do the similar with other elements
//TC=O(2N)
//SC=O(1)
public class ReverseNodesInKGroup {
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
    private static Node findKthNode(Node head, int k){
        k -= 1;
        while (head!=null && k>0){
            k--;
            head=head.next;
        }
        return head;
    }
    private static Node rev(Node head){
        Node temp=head, prev=null, front;
        if(head==null || head.next==null){
            return head;
        } else {
            while (temp!=null){
                front=temp.next;
                temp.next=prev;
                prev=temp;
                temp=front;
            }
            return prev;
        }
    }

    private static Node finalRev(Node head, int k){
        Node temp=head;
        Node prevNode=null;
        while (temp!=null){
            Node kthNode=findKthNode(temp,k);
            if(kthNode==null){
                if (prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }
            Node nextNode=kthNode.next;
            kthNode.next=null;
            rev(temp);
            if(temp==head){
                head=kthNode;
            } else {
                prevNode.next=kthNode;
            }
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Node head = convert2LL(arr);
        head=finalRev(head,3);
        print(head);
    }
}
