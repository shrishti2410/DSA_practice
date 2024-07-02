//Given a linked list containing ‘N’ head nodes where every node in the linked list contains two pointers: ‘Next’ points to the next node in the list ‘Child’ pointer to a linked list where the current node is the head
//To transform the given linked list into a single level sorted list ensuring that the nodes are arranged in an ascending order

//Brute force-We initialise an array to temporarily hold the extracted nodes during the traversal. Then the array is sorted to arrange all values sequentially and a new linked list from that array is created and returned.
//TC-O(N*M)+O(XlogX)+O(N*M)=O(2*N*M)
//SC-O(2*N*M)

//Optimal-Merge two lists, then use recursion
//TC=O(2*M*N)
//SC=O(N)

class Node2 {
    int data;
    Node2 next;
    Node2 child;

    // Constructors to initialize the
    // data, next, and child pointers
    Node2() {
        this.data = 0;
        this.next = null;
        this.child = null;
    }

    Node2(int x) {
        this.data = x;
        this.next = null;
        this.child = null;
    }

    Node2(int x, Node2 nextNode, Node2 childNode) {
        this.data = x;
        this.next = nextNode;
        this.child = childNode;
    }
}
public class FlattenLL {
    public static Node2 merge(Node2 list1, Node2 list2) {
        Node2 dummyNode = new Node2(-1);
        Node2 res = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                res.child = list1;
                res = list1;
                list1 = list1.child;
            } else {
                res.child = list2;
                res = list2;
                list2 = list2.child;
            }
            res.next = null;
        }
        if (list1 != null) {
            res.child = list1;
        } else {
            res.child = list2;
        }
        if (dummyNode.child != null) {
            dummyNode.child.next = null;
        }
        return dummyNode.child;
    }

    public static Node2 flattenLinkedList(Node2 head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node2 mergedHead = flattenLinkedList(head.next);
        head = merge(head, mergedHead);
        return head;
    }

    public static void printLinkedList(Node2 head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.child;
        }
        System.out.println();
    }


    public static void printOriginalLinkedList(Node2 head, int depth) {
        while (head != null) {
            System.out.print(head.data);

            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);
            }

            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node2 head = new Node2(5);
        head.child = new Node2(14);

        head.next = new Node2(10);
        head.next.child = new Node2(4);

        head.next.next = new Node2(12);
        head.next.next.child = new Node2(20);
        head.next.next.child.child = new Node2(13);

        head.next.next.next = new Node2(7);
        head.next.next.next.child = new Node2(17);

        System.out.println("Original linked list:");
        printOriginalLinkedList(head, 0);

        Node2 flattened = flattenLinkedList(head);
        System.out.print("\nFlattened linked list: ");
        printLinkedList(flattened);
    }
}
