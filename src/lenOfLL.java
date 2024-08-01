import java.util.*;
public class lenOfLL {
    private static Node a2LL(int[] arr){
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
        int[] arr={12, 5, 8};
        Node head=a2LL(arr);
        Node temp=head;
        int cnt=0;
        while(temp!=null){
            //System.out.print(temp.data+" ");
            temp=temp.next;
            cnt++;
        }
        System.out.println(cnt);
    }
}

