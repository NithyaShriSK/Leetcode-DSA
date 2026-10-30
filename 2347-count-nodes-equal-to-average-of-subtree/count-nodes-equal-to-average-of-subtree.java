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
    int count=0;
    int node(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=node(root.left);
        int right=node(root.right);
        return left+right+1;
    }
    int avg(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftn=node(root.left);
        int rightn=node(root.right);
        int left=avg(root.left);
        int right=avg(root.right);
        if((left+right+root.val)/(leftn+rightn+1)==root.val){
            count++;
        }
        return left+right+root.val;
    }
    public int averageOfSubtree(TreeNode root) {
        int tcount=0;
        int res=avg(root);
        return count;
    }
}