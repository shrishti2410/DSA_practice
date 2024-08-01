//Brute force-Use hashmaps(Store the entire node)
//TC-O(N*TC of Maps)
//SC-O(N)

//Optimal-Tortoise and hare algo-if slow and fast pointer meet, then it is a loop
//TC-
//SC-

import java.util.*;
public class DetectLoopInLL {
    public static boolean detectCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches the end of the
        // list, there is no loop
        return false;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = third;

        if (detectCycle(head)) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}



