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
    int small(TreeNode root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int left=small(root.left);
        int right=small(root.right);
        return Math.min(root.val,Math.min(left,right));

    }
    TreeNode remove(TreeNode root,int small){
        if(root==null){
            return null;
        }
        if(root.val==small){
            return root.right;
            
        }
        root.left=remove(root.left,small);
        root.right=remove(root.right,small);
        return root;
    }
    TreeNode preorder(TreeNode root,int key){
        if(root==null){
            return null;
        }
        if(root.val==key){
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            int small=small(root.right);
            root.right=remove(root.right,small);
            System.out.println(small);
            root.val=small;
            
            return root;
        }
        if(key < root.val){
            root.left = preorder(root.left, key);
        } else {
            root.right = preorder(root.right, key);
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        return preorder(root,key);
    }
}