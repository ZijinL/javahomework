import java.util.Scanner;

public class reverseLinkedList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        if (length == 0) {
            input.close();
            return;
        }
        ListNode head = new ListNode(input.nextInt());
        ListNode tail = head;
        for (int i = 0; i < length - 1; i++) {
            tail.next = new ListNode(input.nextInt());
            tail = tail.next;
        }
        input.close();
        if (head != null)
            head = reverseList(head);
        printList(head);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode cur, nxt;
        cur = head;
        nxt = cur.next;
        while (nxt != null) {
            head.next = nxt.next;
            nxt.next = cur;
            cur = nxt;
            nxt = head.next;
        }
        return cur;
    }

    public static void printList(ListNode head) {
        while (head.next != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.print(head.val);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}