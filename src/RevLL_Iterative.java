//Brute force=Use stack
//TC=O(2N)
//SC=O(N)-stack

//Optimal-reverse the links
//TC=0(N)
//SC=0(1)

public class RevLL_Iterative {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        //{4,3,2,1}
        Node head = convert2LL(arr);
        head=revLL(head);
        print(head);
    }

    private static Node revLL(Node head){
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
