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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0)return head;
        int n = 0;
        ListNode temp = head;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        if(n == 1 && k == 1)return head;
        k = k % n;
        if(k == 0)return head;
        int move = n-1-k;
        temp = head;
        for(int i =1 ; i <= move ; i++){
            temp = temp.next;
        }
        ListNode add = temp.next;
        temp.next = null;
        ListNode t = add;
        while(t.next != null)t = t.next;
        t.next = head;
        return add;
    }
}