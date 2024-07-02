//Brute force-Nested loop-temp1 and temp2
//TC=O(N^2)
//SC=O(1)

//Optimal-Using left and right pointers
//TC=O(2N)
//SC=O(1)

//import java.util.HashMap;
//import java.util.Map;
//import java.util.Stack;
//public class PairsWithGivenSum {
//    private static Node a2LL(int[] arr){
//        Node head=new Node(arr[0]);
//        Node mover=head;
//        for(int i=1; i<arr.length; i++){
//            Node temp=new Node(arr[i]);
//            mover.next=temp;
//            mover=temp;
//        }
//        return head;
//    }
//    private static HashMap<Integer, Integer> PairsWithGivenSumInSortedDLL(Node head, int sum){
//        HashMap<Integer,Integer> ds=new HashMap<>();
//        Node temp1=head;
//        Node temp2=head;
//        while(temp1!=null){
//            temp2=temp1.next;
//            while (temp2!=null && temp1.data+temp2.data<=sum){
//                if(temp1.data+temp2.data==sum){
//                    ds.put(temp1.data,temp2.data);
//                }
//                temp2=temp2.next;
//            }
//            temp1=temp1.next;
//        }
//        return ds;
//    }
//
//    public static void main(String[] args) {
//        int[] arr={1,2,3,4,9};
//        Node head=a2LL(arr);
//        System.out.println(pairsWithGivenSum_SortedLL(head,5));
//    }
//}
//


import java.util.*;

public class PairsWithGivenSumInSortedDLL {
    private static Node1 convert2DLL(int[] arr){
        Node1 head=new Node1(arr[0]);
        Node1 prev=head;
        for(int i=1; i<arr.length; i++){
            Node1 temp=new Node1(arr[i], null,prev);
            prev.next=temp;
            prev=temp;
        }
        return head;
    }
    private static ArrayList<ArrayList<Integer>> pairsWithGivenSum_SortedLL(Node1 head, int sum){
        ArrayList<ArrayList<Integer>> ds=new ArrayList<>();
        Node1 left=head;
        Node1 right=head;
        while (right.next!=null){
            right=right.next;
        }
        while (left.data<right.data){
            if(left.data+ right.data==sum){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                ds.add(pair);
                left = left.next;
                right = right.back;
            } else if (left.data+ right.data<sum) {
                left=left.next;
            } else {
                right=right.back;
            }
        }
        return ds;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,9};
        Node1 head=convert2DLL(arr);
        System.out.println(pairsWithGivenSum_SortedLL(head,5));
    }
}