//Brute force-Reach (n/2)th node
//TC-O(N+N/2)
//SC-O(1)

//Optimal-Tortoise and hare algo-Skip one step of slow
//TC-O(N)
//SC-O(1)

public class DelAllOccurencesOfAGivenKeyInDLL {

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
    private static void printDLL(Node1 head) {
        Node1 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 10, 10, 6, 10};
        int key = 10;
        Node1 head = convert2DLL(arr);

        System.out.println("Original DLL:");
        printDLL(head);

        Node1 temp = head;
        while (temp != null) {
            if (temp.data == key) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) {
                        head.back = null;
                    }
                } else {
                    Node1 nextNode = temp.next;
                    Node1 prevNode = temp.back;
                    if (nextNode != null) {
                        nextNode.back = prevNode;
                    }
                    if (prevNode != null) {
                        prevNode.next = nextNode;
                    }
                }
            }
            temp = temp.next;
        }

        System.out.println("DLL after deleting all occurrences of " + key + ":");
        printDLL(head);
    }
}