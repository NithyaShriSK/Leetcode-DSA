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
    int sum=0;
    void add(TreeNode root){
        if(root==null){
            return;
        }
        add(root.right);
        sum+=root.val;
        root.val=sum;
        add(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        add(root);
        return root;
    }
}