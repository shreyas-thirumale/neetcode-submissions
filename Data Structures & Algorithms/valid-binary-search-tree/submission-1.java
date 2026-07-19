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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        else return helper(root.left, Long.MIN_VALUE, root.val, true) && helper(root.right, root.val, Long.MAX_VALUE, false);
    }
    private boolean helper(TreeNode root, long min, long max, boolean isLeft) {
        if (root == null) return true;
        else if (isLeft) {
            if (root.val < max && root.val > min) return true && helper(root.left, min, root.val, true) && helper(root.right, root.val, max, false); 
            else return false;
        } else {
            if (root.val > min && root.val < max) return true && helper(root.left, min, root.val, true) && helper(root.right, root.val, max, false); 
            else return false;
        }
    }
}
