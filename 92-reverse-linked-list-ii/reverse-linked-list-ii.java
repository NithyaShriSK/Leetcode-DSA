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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp=head;
        int[] res=new int[right-left+1];
        int count=1;
        int k=0;
        while(temp!=null){
            if(count>=left && count<=right) {
                res[k++]=temp.val;
            }
            temp=temp.next;
            count++;
        }
        temp=head;
        count=1;
        int l=res.length-1;
        while(temp!=null){
            if(count>=left && count<=right){
                temp.val=res[l--];
            }
            count++;
            temp=temp.next;
        }
        return head;
    }
}