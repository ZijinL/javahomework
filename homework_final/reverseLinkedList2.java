import java.util.Scanner;

public class reverseLinkedList2 {
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
        if(head.next != null) {
            ListNode temp = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return temp;
        }
        else {
            return head;
        }
        
    }

    // 错误做法，一定要返回初始状态的尾结点
    // public static ListNode reverseList2(ListNode head) {
    //     if(head.next != null) {
    //         reverseList2(head.next).next = head;
    //         head.next = null;
    //         return head;
    //     }
    //     else {
    //         return head;
    //     }
        
    // }

    public static void printList(ListNode head) {
        while (head.next != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.print(head.val);
    }
}

// class ListNode {
//     int val;
//     ListNode next;

//     ListNode(int x) {
//         val = x;
//         next = null;
//     }
// }