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
    public int goodNodes(TreeNode root) {
        return goodNodes(Integer.MIN_VALUE, root);
    }
    private int goodNodes(int largest, TreeNode root) {
        if (root == null) return 0;
        else if (root.val >= largest) {
            largest = Math.max(largest, root.val);
            return 1 + goodNodes(largest, root.right) + goodNodes(largest, root.left);
        } else {
            largest = Math.max(largest, root.val);
            return goodNodes(largest, root.right) + goodNodes(largest, root.left);
        }
    }
}
