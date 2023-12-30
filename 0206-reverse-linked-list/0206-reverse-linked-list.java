class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode prev = null;
        ListNode newCurr = null;

        while(curr != null) {
            newCurr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newCurr;
        }

        return prev;
    }
}