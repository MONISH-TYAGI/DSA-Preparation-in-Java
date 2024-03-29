//https://leetcode.com/problems/binary-tree-tilt/

class Solution {
    int tilt = 0;
    public int helper(TreeNode root){
        if(root == null) return 0;
        
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        tilt += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
    public int findTilt(TreeNode root) {
        helper(root);
        return tilt;
    }
}