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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1=new ListNode(-101);
        ListNode dummy2=new ListNode(101);
        ListNode last=dummy2;
        ListNode prev=dummy1;
       ListNode curr=head;
        while(curr!=null){
            if(curr.val<x){
                prev.next=curr;
                prev=curr;
            }
            else{
                last.next=curr;
                last=curr;
            }
            curr=curr.next;
        }
        last.next=null;
        prev.next=dummy2.next;
        return dummy1.next;
    }
}