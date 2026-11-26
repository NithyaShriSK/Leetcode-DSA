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
    TreeNode add(int[] nums,int left,int right){
        if(left>right){
            return null;
        }
        int maxind=left;
        for(int i=left;i<=right;i++){
            if(nums[i]>nums[maxind]){
                maxind=i;
            }
        }
        TreeNode root=new TreeNode(nums[maxind]);
        root.left=add(nums,left,maxind-1);
        root.right=add(nums,maxind+1,right);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return add(nums,0,nums.length-1);
    }
}