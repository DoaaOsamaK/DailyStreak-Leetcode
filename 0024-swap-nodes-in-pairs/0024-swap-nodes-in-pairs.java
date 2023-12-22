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
    public ListNode swapPairs(ListNode head) {
        if(head==null){
            return head;
        }
        else if(LLsize(head)==1){
            return head;
        }else{
            ListNode temp=head;
            while(temp!=null){
                int first=temp.val;
                int second=0;
                if(temp.next!=null){
                    second=temp.next.val;
                }else{
                    return head;
                }
                temp.val=second;                
                temp.next.val=first;                
                if(temp.next.next!=null){
                    temp=temp.next.next;
                }else
                    return head;
            }
            return head;
        }
    }
    int LLsize(ListNode head){
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
}