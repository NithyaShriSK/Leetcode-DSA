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
    void ladd(TreeNode root,List<Integer> li){
        if(root==null){
            return;
        }
        ladd(root.left,li);
        li.add(root.val);
        ladd(root.right,li);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer>li=new ArrayList();
        ladd(root1,li);
        ladd(root2,li);
        Collections.sort(li);
        return li;
    }
}