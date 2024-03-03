/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    int findSize(ListNode head ){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
   public ListNode removeNthFromEnd(ListNode head, int n) {
    int listSize = findSize(head);
    int breakSize = listSize - n;

    if (breakSize == 0) {
        return head.next;
    }

    int cnt = 1;
    ListNode curr = head;

    while (curr != null && curr.next != null) {
        if (cnt < breakSize) {
            curr = curr.next;
            cnt++;
        } else {
            curr.next = curr.next.next;
            break;
        }
    }

    return head;
}
}