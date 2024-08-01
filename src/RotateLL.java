//TC=O(2N)
public class RotateLL {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        //{4,3,2,1}
        Node head = convert2LL(arr);
        head=rotateLL(head,4);
        print(head);
    }

    private static Node rotateLL(Node head, int k){
        Node temp=head;
        int len=1;
        while(temp.next!=null){
            len++;
            temp=temp.next;
        }
        if(k%len==0){
            return head;
        }
        int n=k%len;
        int N=len-n;
        Node temp1=head;
        while (N>1){
            N--;
            temp1=temp1.next;
        }
        temp.next=head;
        head=temp1.next;
        temp1.next=null;
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
    private static void print(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
}