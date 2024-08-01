//Brute force-Use hashmaps(Store the entire node), first node that is alr present is the starting point of loop
//TC-O(N*TC of Maps)
//SC-O(N)

//Optimal-Tortoise and hare algo-if slow and fast pointer meet, then it is a loop. As soon as they meet, place one pointer at the starting of the LL, then start moving them by one place, as soon as they collide, we get the starting point of the loop
//TC-
//SC-

import java.util.*;
public class DetectStartingNodeOfLoop {
    public static Node detectCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow=head;
                while (slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return fast;
            }
        }
        return null;
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

        Node loopStartNode = detectCycle(head);
        if (loopStartNode != null) {
            System.out.println("Cycle detected at node with value: " + loopStartNode.data);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}



