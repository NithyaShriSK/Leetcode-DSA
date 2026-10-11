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
    public int sumNumbers(TreeNode root) {
        path(root,0);
        return sum;
    }
    void path(TreeNode root,int path){
        if(root==null) return;
        path=path*10+root.val;
        if(root.left==null && root.right==null)sum+=path;
        path(root.left,path);
        path(root.right,path);
    }
}