public class Add2NosInLL {
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
            Node1 temp=new Node1(arr[i], null, prev);
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
        int[] arr1={2,4,6};
        int[] arr2={3,8,7};
        //{1,4,2,5}

        // Creating a new Node with the value from the array
        Node1 head1 = convert2DLL(arr1);
        head1=revDLL(head1);
        Node1 head2 = convert2DLL(arr2);
        head2=revDLL(head2);

        //print(head);
    }
}
