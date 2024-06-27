//Brute force-Put all the elements in a external data structure, srt it n then put all the elements in LL
//TC-O(N)+O(NlogN)+O(N)
//SC-O(N)

//Optimal-Apply merge sort on LL
//TC=O(N+N/2)+O(logN)
//SC=O(1)

public class SortEntireLL {
    public static void main(String[] args) {
        int[] arr = {14,5,6,3,7,3,10,5,8};
        Node head = convert2LL(arr);
        head=merge_sort(head);
        print(head);
    }
    private static Node merge_sort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node mid=findMid(head);
        Node leftHead=head;
        Node rightHead=mid.next;
        mid.next=null;
        leftHead=merge_sort(leftHead);
        rightHead=merge_sort(rightHead);
        head=merge2(leftHead,rightHead);
        return head;
    }
    private static Node findMid(Node head){
        if (head == null) {
            return null;
        }
        Node slow=head, fast=head.next;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private static Node merge2(Node head1, Node head2){
        Node dNode=new Node(-1);
        Node temp=dNode, t1=head1, t2=head2;
        while (t1!=null && t2!=null){
            if(t1.data>t2.data){
                temp.next=t2;
                temp=t2;
                t2=t2.next;
            } else {
                temp.next=t1;
                temp=t1;
                t1=t1.next;
            }
        }
        if(t1!=null){
            temp.next=t1;
        } else {
            temp.next=t2;
        }
        return dNode.next;
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

