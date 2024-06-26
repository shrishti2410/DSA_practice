//Brute force-Put all the elements in an arrayList and then sort it, then convert to LL
//TC=O(N1)+O(N2)+O(NlogN)+O(N)
//SC=O(N)+O(N)

//Optimal-Concept of 2 pointers
//TC=O(N1)+O(N2)
//SC=O(1)

public class MergeSortedLL {
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,8};
        int[] arr2 = {2,4,6,7,10};
        Node head1 = convert2LL(arr1);
        Node head2 = convert2LL(arr2);
        head1=merge(head1,head2);
        print(head1);
    }

    private static Node merge(Node head1, Node head2){
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
