////TC=O(2N)
////SC=O(N)
//public class OddEvenNodes {
//    private static Node OddEven(int arr[]){
//        Node head=new Node(arr[0]);
//        Node mover=head;
//        for(int i=2; i< arr.length; i=i+2){
//            Node temp=new Node(arr[i]);
//            mover.next=temp;
//            mover=temp;
//        }
//        for(int i=1; i< arr.length; i=i+2){
//            Node temp=new Node(arr[i]);
//            mover.next=temp;
//            mover=temp;
//        }
//        return head;
//    }
//
//    private static void print(Node head){
//        while(head!=null){
//            System.out.print(head.data+" ");
//            head=head.next;
//        }
//        System.out.println();
//    }
//
//
//    public static void main(String[] args) {
//        int[] arr = {2, 4, 6, 8, 10};
//        //{2,6,10,4,8}
//        Node head=OddEven(arr);
//        print(head);
//    }
//}

//TC=N/2*2=O(N)
//SC=O(1)
public class OddEvenNodes {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        //{2,6,10,4,8}
        Node head = convert2LL(arr);
        head = OddEven(head);
        print(head);
    }
    private static Node OddEven(Node head){
        if(head==null || head.next==null){
            return head;
        }else {
            Node odd = head;
            Node even = head.next;
            Node evenHead = head.next;
            while (even!=null && even.next!=null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
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