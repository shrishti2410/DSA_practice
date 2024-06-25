//Brute force-Store the data in stack n then pop it n compare it

//Optimal-Recognise the two halves of the LL (by finding the middle element), then reverse the second half, now take 2 pointers - first and second, place first on the head and second on the middle element, now check first and second and increment them by one
//TC=O(N/2)+O(N/2)+O(N/2)+O(N/2)=O(2N)
//SC=O(1)

import java.util.*;
public class CheckIfPalindrome  {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,3,2,1};
        Node head = convert2LL(arr);
        if(isPalindrome(head)==true){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    private static boolean isPalindrome(Node head){
        if (head == null || head.next == null) {
            return true;
        } else {
            Node slow = head, fast = head;
            while (fast != null && fast.next!=null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            Node newHead = rev(slow.next);
            Node first = head, second = newHead;
            while (second != null) {
                if (first.data != second.data) {
                    rev(newHead);
                    return false;
                }
                first = first.next;
                second = second.next;
            }
            rev(newHead);
            return true;
        }
    }
    private static Node rev(Node head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            Node newHead=rev(head.next);
            Node front=head.next;
            front.next=head;
            head.next=null;
            return newHead;
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
}
