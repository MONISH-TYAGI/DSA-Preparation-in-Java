//https://leetcode.com/problems/count-complete-tree-nodes/

class Solution {
    public int leftMostdepth(TreeNode root){
        int ans = 0;
        while(root != null){
            ans++;
            root = root.left;
        }
        return ans;
    }
    public int rightMostdepth(TreeNode root){
        int ans = 0;
        while(root != null){
            ans++;
            root = root.right;
        }
        return ans;
    }
    
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        // Is Tree Perfect
        int left = leftMostdepth(root); // O(H)
        int right = rightMostdepth(root); // O(H)
        
        // No of nodes in perfect tree of height h is 2 ^ h - 1
        if(left == right) return ((1 << left) - 1);
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}