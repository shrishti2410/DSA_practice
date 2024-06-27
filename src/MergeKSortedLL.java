//Brute force-We initialise an array to temporarily hold the extracted nodes during the traversal. Then the array is sorted to arrange all values sequentially and a new linked list from that array is created and returned.
//TC-O(N*K)+O(MlogM)+O(M)=O(2*N*M)
//M=N*K
//SC-O(2*M)

//Better-Merge two lists, then use recursion
//TC=(for 3lists)-O(N1+N2)+O(N1+N2+N3)=O(N(K*(K+1))/2)=O(N^3)
//SC=O(1)

//Optimal-Define PQ in terms of min heap
//TC=O(KlogK)+O(N*K*logK)
//SC=O(K)

//Better-
//import java.util.ArrayList;
//public class MergeKSortedLL {
//    public static void main(String[] args) {
//        int[][] lists = {
//                {1, 4, 5},
//                {1, 3, 4},
//                {2, 6}
//        };
//
//        ArrayList<Node> nodes = new ArrayList<>();
//        for (int[] list : lists) {
//            nodes.add(convert2LL(list));
//        }
//
//        Node mergedHead = merge(nodes);
//        print(mergedHead);
//    }
//
//
//    private static Node convert2LL(int arr[]){
//        if (arr.length == 0) return null;
//        Node head=new Node(arr[0]);
//        Node mover=head;
//        for(int i=1; i<arr.length; i++){
//            Node temp=new Node(arr[i]);
//            mover.next=temp;
//            mover=temp;
//        }
//        return head;
//    }
//    private static void print(Node head){
//        while(head!=null){
//            System.out.print(head.data+" ");
//            head=head.next;
//        }
//        System.out.println();
//    }
//    private static Node merge2LL(Node head1, Node head2){
//        Node dNode=new Node(-1);
//        Node temp=dNode, t1=head1, t2=head2;
//        while (t1!=null && t2!=null){
//            if(t1.data>t2.data){
//                temp.next=t2;
//                temp=t2;
//                t2=t2.next;
//            } else {
//                temp.next=t1;
//                temp=t1;
//                t1=t1.next;
//            }
//        }
//        if(t1!=null){
//            temp.next=t1;
//        } else {
//            temp.next=t2;
//        }
//        return dNode.next;
//    }
//    private static Node merge(ArrayList<Node> al) {
//        if (al.size() == 0) return null;
//        if (al.size() == 1) return al.get(0);
//
//        while (al.size() > 1) {
//            ArrayList<Node> newAL = new ArrayList<>();
//            for (int i = 0; i < al.size(); i += 2) {
//                if (i + 1 < al.size()) {
//                    newAL.add(merge2LL(al.get(i), al.get(i + 1)));
//                } else {
//                    newAL.add(al.get(i));
//                }
//            }
//            al = newAL;
//        }
//        return al.get(0);
//    }
//}

//Optimal-
import java.util.ArrayList;
import java.util.PriorityQueue;

class Node3 implements Comparable<Node3> {
    int data;
    Node3 next;

    public Node3(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public int compareTo(Node3 other) {
        return Integer.compare(this.data, other.data);
    }
}

public class MergeKSortedLL {
    private static Node3 merge(ArrayList<Node3> al) {
        PriorityQueue<Node3> pq = new PriorityQueue<>();

        for (int i = 0; i < al.size(); i++) {
            if (al.get(i) != null) {
                pq.add(al.get(i));
            }
        }

        Node3 dummy = new Node3(0);
        Node3 current = dummy;

        while (!pq.isEmpty()) {
            Node3 minNode = pq.poll();
            current.next = minNode;
            current = current.next;

            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example usage
        Node3 n1 = new Node3(1);
        n1.next = new Node3(4);
        n1.next.next = new Node3(5);

        Node3 n2 = new Node3(1);
        n2.next = new Node3(3);
        n2.next.next = new Node3(4);

        Node3 n3 = new Node3(2);
        n3.next = new Node3(6);

        ArrayList<Node3> list = new ArrayList<>();
        list.add(n1);
        list.add(n2);
        list.add(n3);

        Node3 merged = merge(list);
        while (merged != null) {
            System.out.print(merged.data + " ");
            merged = merged.next;
        }
    }
}
