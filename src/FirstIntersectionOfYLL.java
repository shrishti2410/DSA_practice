//Brute force-Use a map data structure to store nodes(not the values)
//TC=O(N1*N1logN1)+O(N2*N2logN2)
//SC=O(N1)

//Better-Fine the diff in the lengths of 2 LL and then compare each element
//TC=O(N1)+O(N2)+O(N2-N1)+O(N1)=O(N1+2N2)
//SC=O(1)

//Optimal-
//TC=O(N1+N2)
//SC=O(1)

//Brute force:
//import java.util.*;
//public class FirstIntersectionOfYLL {
//    public static void main(String[] args) {
//        Node head = null;
//        head=insertNode(head,1);
//        head=insertNode(head,3);
//        head=insertNode(head,1);
//        head=insertNode(head,2);
//        head=insertNode(head,4);
//        Node head1 = head;
//        head = head.next.next.next;
//        Node headSec = null;
//        headSec=insertNode(headSec,3);
//        Node head2 = headSec;
//        headSec.next = head;
//        //printing of the lists
//        System.out.print("List1: "); printList(head1);
//        System.out.print("List2: "); printList(head2);
//        //checking if intersection is present
//        Node answerNode = intersectionPresent(head1,head2);
//        if(answerNode == null)
//            System.out.println("No intersection\n");
//        else
//            System.out.println("The intersection point is "+answerNode.data);
//    }
//
//    static Node insertNode(Node head,int val) {
//        Node newNode = new Node(val);
//
//        if(head == null) {
//            head = newNode;
//            return head;
//        }
//
//        Node temp = head;
//        while(temp.next != null) temp = temp.next;
//
//        temp.next = newNode;
//        return head;
//    }
//    private static Node intersectionPresent(Node head1, Node head2){
//        Map<Node, Integer> mpp=new HashMap<>();
//        Node temp=head1;
//        while (temp!=null){
//            mpp.put(temp,1);
//            temp=temp.next;
//        }
//        temp=head2;
//        while (temp!=null){
//            if(mpp.containsKey(temp)){
//                return temp;
//            } else {
//                temp=temp.next;
//            }
//        }
//        return null;
//    }
//    static void printList(Node head) {
//        while(head.next != null) {
//            System.out.print(head.data+"->");
//            head = head.next;
//        }
//        System.out.println(head.data);
//    }
//}

//Better:
//import java.util.*;
//public class FirstIntersectionOfYLL {
//    public static void main(String[] args) {
//        Node head = null;
//        head=insertNode(head,1);
//        head=insertNode(head,3);
//        head=insertNode(head,1);
//        head=insertNode(head,2);
//        head=insertNode(head,4);
//        Node head1 = head;
//        head = head.next.next.next;
//        Node headSec = null;
//        headSec=insertNode(headSec,3);
//        Node head2 = headSec;
//        headSec.next = head;
//        //printing of the lists
//        System.out.print("List1: "); printList(head1);
//        System.out.print("List2: "); printList(head2);
//        //checking if intersection is present
//        Node answerNode = intersectionPresent(head1,head2);
//        if(answerNode == null)
//            System.out.println("No intersection\n");
//        else
//            System.out.println("The intersection point is "+answerNode.data);
//    }
//
//    static Node insertNode(Node head,int val) {
//        Node newNode = new Node(val);
//
//        if(head == null) {
//            head = newNode;
//            return head;
//        }
//
//        Node temp = head;
//        while(temp.next != null) {
//            temp = temp.next;
//        }
//
//        temp.next = newNode;
//        return head;
//    }
//    private static Node intersectionPresent(Node head1, Node head2){
//        int diff=getDiff(head1, head2);
//        if(diff<0){
//            //list2>list1
//            while(diff++ != 0) head2 = head2.next;
//        } else {
//            while(diff-- != 0) {
//                head1 = head1.next;
//            }
//            while(head1 != null) {
//                if (head1 == head2) return head1;
//                head2 = head2.next;
//                head1 = head1.next;
//            }
//        }
//        return head1;
//    }
//
//    private static int getDiff(Node head1, Node head2){
//        int len1 = 0,len2 = 0;
//        while(head1 != null || head2 != null) {
//            if(head1 != null) {
//                ++len1;
//                head1 = head1.next;
//            }
//            if(head2 != null) {
//                ++len2; head2 =
//                        head2.next;
//            }
//
//        }
//        return len1-len2;
//    }
//    static void printList(Node head) {
//        while(head.next != null) {
//            System.out.print(head.data+"->");
//            head = head.next;
//        }
//        System.out.println(head.data);
//    }
//}

//Optimal:
import java.util.*;
public class FirstIntersectionOfYLL {
    public static void main(String[] args) {
        Node head = null;
        head=insertNode(head,1);
        head=insertNode(head,3);
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,4);
        Node head1 = head;
        head = head.next.next.next;
        Node headSec = null;
        headSec=insertNode(headSec,3);
        Node head2 = headSec;
        headSec.next = head;
        //printing of the lists
        System.out.print("List1: "); printList(head1);
        System.out.print("List2: "); printList(head2);
        //checking if intersection is present
        Node answerNode = intersectionPresent(head1,head2);
        if(answerNode == null)
            System.out.println("No intersection\n");
        else
            System.out.println("The intersection point is "+answerNode.data);
    }

    static Node insertNode(Node head,int val) {
        Node newNode = new Node(val);

        if(head == null) {
            head = newNode;
            return head;
        }

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }
    private static Node intersectionPresent(Node head1, Node head2){
        if(head1==null || head2==null){
            return null;
        }
        Node d1=head1, d2=head2;
        while(d1 != d2) {
            d1=d1.next;
            d2=d2.next;
           if(d1==d2){
               return d1;
           }
           if(d1==null){
               d1=head2;
           }
           if(d2==null){
               d2=head1;
           }
        }
        return d1;
    }
    static void printList(Node head) {
        while(head.next != null) {
            System.out.print(head.data+"->");
            head = head.next;
        }
        System.out.println(head.data);
    }
}
