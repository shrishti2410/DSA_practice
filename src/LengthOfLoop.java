//Brute force-Use hashmaps(Store the entire node).Keep traversing and inv=crease the timer by 1. As soon as the first node of loop is reached, subtract the final value of timer to initial value and you will get the length of LL
//TC-O(N*TC of Maps)
//SC-O(N)

//Optimal-Tortoise and hare algo-as soon as fast and slow meet, make one of them to move again(one step), as soon as they meet again, the cnt is the length of the loop
//TC-
//SC-

import java.sql.SQLOutput;

public class LengthOfLoop {
    public static int detectCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return fullLen(slow, fast);
            }
        }
        return 0;
    }

    public static int fullLen(Node slow, Node fast) {
        int cnt=1;
        fast=fast.next;
        while(slow!=fast){
            cnt++;
            fast=fast.next;
        }
        return cnt;
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
        System.out.println(detectCycle(head));
    }
}



