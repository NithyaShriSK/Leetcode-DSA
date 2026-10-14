/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        int j=0;
        Queue<TreeNode>q=new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> arr=new ArrayList();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                arr.add(node.val);
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            if(j%2!=0){
                Collections.reverse(arr);
            }j++;
            res.add(arr);
        }return res;
    }
}