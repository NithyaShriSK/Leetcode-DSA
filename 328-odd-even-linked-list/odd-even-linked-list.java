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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd=new ListNode(0);
        ListNode even=new ListNode(0);
        ListNode temp1=odd;
        ListNode temp2=even;
        int ind=1;
        while(head!=null){
            if(ind%2==0){
                temp2.next=head;
                temp2=head;
            }
            else{
                temp1.next=head;
                temp1=head;
            }
            head=head.next;
            ind++;
        }
        temp2.next=null;
        temp1.next=even.next;
        return odd.next;
        
    }
}