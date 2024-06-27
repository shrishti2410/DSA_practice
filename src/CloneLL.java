//Clone LL with next and random pointers

//Brute force-To create a deep copy of the original linked list we can use a map to establish a relationship between original nodes and their copied nodes. We traverse the list first to create a copied node for each original node then traverse and establish the correct connections between the copied nodes similar to the arrangement of next and random pointers of the original pointers. In the end, return the head of the copied list obtained from the map.
//TC=O(2N)
//SC=O(2N)

//Optimal-Instead of creating duplicate nodes and storing them in a map, insert it in between the original node and the next node for quick access without the need for additional space. Traverse the list again to set the random pointer of copied nodes to the corresponding copied node duplicating the original arrangement. As a final traversal, separate the copied and original nodes by detaching alternate nodes.
//TC=O(N)+O(N)+O(N)=O(3N)
//SC=O(N)

//import java.util.HashMap;
//class Node4 {
//    int data;
//    // Pointer to the next node
//    Node4 next;
//    // Pointer to a random node in the list
//    Node4 random;
//    Node4() {
//        this.data = 0;
//        this.next = null;
//        this.random = null;
//    }
//
//    Node4(int x) {
//        this.data = x;
//        this.next = null;
//        this.random = null;
//    }
//
//    Node4(int x, Node4 nextNode, Node4 randomNode) {
//        this.data = x;
//        this.next = nextNode;
//        this.random = randomNode;
//    }
//}
//
//public class CloneLL {
//    // Function to clone the linked list
//    public static Node4 cloneLL(Node4 head) {
//        Node4 temp = head;
//        // Create a HashMap to map original nodes
//        // to their corresponding copied nodes
//        HashMap<Node4, Node4> map = new HashMap<>();
//
//        // Step 1: Create copies of each
//        // node and store them in the map
//        while (temp != null) {
//            // Create a new node with the
//            // same data as the original node
//            Node4 newNode = new Node4(temp.data);
//            // Map the original node to its
//            // corresponding copied node in the map
//            map.put(temp, newNode);
//            // Move to the next node in the original list
//            temp = temp.next;
//        }
//
//        temp = head;
//        // Step 2: Connect the next and random
//        // pointers of the copied nodes using the map
//        while (temp != null) {
//            // Access the copied node corresponding
//            // to the current original node
//            Node4 copyNode = map.get(temp);
//            // Set the next pointer of the copied node
//            // to the copied node mapped to the
//            // next node in the original list
//            copyNode.next = map.get(temp.next);
//            // Set the random pointer of the copied node
//            // to the copied node mapped to the
//            // random node in the original list
//            copyNode.random = map.get(temp.random);
//            // Move to the next node in the original list
//            temp = temp.next;
//        }
//
//        // Return the head of the
//        // deep copied list from the map
//        return map.get(head);
//    }
//
//    // Function to print the cloned linked list
//    public static void printClonedLinkedList(Node4 head) {
//        while (head != null) {
//            System.out.print("Data: " + head.data);
//            if (head.random != null) {
//                System.out.print(", Random: " + head.random.data);
//            } else {
//                System.out.print(", Random: nullptr");
//            }
//            System.out.println();
//            // Move to the next node in the list
//            head = head.next;
//        }
//    }
//
//    // Main function
//    public static void main(String[] args) {
//        // Example linked list: 7 -> 14 -> 21 -> 28
//        Node4 head = new Node4(7);
//        head.next = new Node4(14);
//        head.next.next = new Node4(21);
//        head.next.next.next = new Node4(28);
//
//        // Assigning random pointers
//        head.random = head.next.next;
//        head.next.random = head;
//        head.next.next.random = head.next.next.next;
//        head.next.next.next.random = head.next;
//
//        System.out.println("Original Linked List with Random Pointers:");
//        printClonedLinkedList(head);
//
//        // Clone the linked list
//        Node4 clonedList = cloneLL(head);
//
//        System.out.println("\nCloned Linked List with Random Pointers:");
//        printClonedLinkedList(clonedList);
//    }
//}

class Node4 {
    // Data stored in the node
    int data;
    // Pointer to the next node
    Node4 next;
    // Pointer to a random
    // node in the list
    Node4 random;

    Node4() {
        // Default constructor
        this.data = 0;
        this.next = null;
        this.random = null;
    }

    Node4(int x) {
        // Constructor with data
        this.data = x;
        this.next = null;
        this.random = null;
    }

    Node4(int x, Node4 nextNode, Node4 randomNode) {
        // Constructor with data,
        // next, and random pointers
        this.data = x;
        this.next = nextNode;
        this.random = randomNode;
    }
}

public class CloneLL {

    // Function to insert a copy of each
// node in between the original nodes
    static void insertCopyInBetween(Node4 head) {
        Node4 temp = head;
        while (temp != null) {
            Node4 nextElement = temp.next;
            // Create a new node with the same data
            Node4 copy = new Node4(temp.data);

            // Point the copy's next to
            // the original node's next
            copy.next = nextElement;

            // Point the original
            // node's next to the copy
            temp.next = copy;

            // Move to the next original node
            temp = nextElement;
        }
    }

    // Function to connect random
// pointers of the copied nodes
    static void connectRandomPointers(Node4 head) {
        Node4 temp = head;
        while (temp != null) {
            // Access the copied node
            Node4 copyNode = temp.next;

            // If the original node
            // has a random pointer
            if (temp.random != null) {
                // Point the copied node's random to the
                // corresponding copied random node
                copyNode.random = temp.random.next;
            } else {
                // Set the copied node's random to
                // null if the original random is null
                copyNode.random = null;
            }

            // Move to the next original node
            temp = temp.next.next;
        }
    }

    // Function to retrieve the deep copy of the linked list
    static Node4 getDeepCopyList(Node4 head) {
        Node4 temp = head;
        // Create a dummy node
        Node4 dummyNode = new Node4(-1);
        // Initialize a result pointer
        Node4 res = dummyNode;

        while (temp != null) {
            // Creating a new List by
            // pointing to copied nodes
            res.next = temp.next;
            res = res.next;

            // Disconnect and revert back to the
            // initial state of the original linked list
            temp.next = temp.next.next;
            temp = temp.next;
        }

        // Return the deep copy of the
        // list starting from the dummy node
        return dummyNode.next;
    }

    // Function to clone the linked list
    static Node4 cloneLL(Node4 head) {
        // If the original list
        // is empty, return null
        if (head == null) return null;

        // Step 1: Insert copy of
        // nodes in between
        insertCopyInBetween(head);
        // Step 2: Connect random
        // pointers of copied nodes
        connectRandomPointers(head);
        // Step 3: Retrieve the deep
        // copy of the linked list
        return getDeepCopyList(head);
    }

    // Function to print the cloned linked list
    static void printClonedLinkedList(Node4 head) {
        while (head != null) {
            System.out.print("Data: " + head.data);
            if (head.random != null) {
                System.out.print(", Random: " + head.random.data);
            } else {
                System.out.print(", Random: null");
            }
            System.out.println();
            // Move to the next node
            head = head.next;
        }
    }

    // Main function
    public static void main(String[] args) {
        // Example linked list: 7 -> 14 -> 21 -> 28
        Node4 head = new Node4(7);
        head.next = new Node4(14);
        head.next.next = new Node4(21);
        head.next.next.next = new Node4(28);

        // Assigning random pointers
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        System.out.println("Original Linked List with Random Pointers:");
        printClonedLinkedList(head);

        Node4 clonedList = cloneLL(head);

        System.out.println("\nCloned Linked List with Random Pointers:");
        printClonedLinkedList(clonedList);
    }
}
