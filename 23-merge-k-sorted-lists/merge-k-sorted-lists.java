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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(ListNode i:lists){
            if(i!=null)
            pq.offer(i);
        }
        ListNode dummy=new ListNode(0);
        ListNode prev=dummy;
        while(!pq.isEmpty()){
            ListNode curr=pq.poll();
            prev.next=curr;
            prev=curr;
            if(curr.next!=null){
                pq.offer(curr.next);
            }
        }
        prev.next=null;
        return dummy.next;
    }
}