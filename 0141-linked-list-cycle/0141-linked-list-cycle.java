/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        int max = 100001;
        ListNode headNode = head;
        while(head != null){
            if(head.val == max){
                return true;
            }
            else{
                head.val =max;
            }
            head = head.next;
        }
        return false;
    }
}