//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
class Solution {
    public TreeNode buildTree(int[] preorder, HashMap<Integer, Integer> inorder, int inL, int inR, int preIdx){
        if(inL > inR) return null;
        
        TreeNode curr = new TreeNode(preorder[preIdx]);
        int inIdx = inorder.get(preorder[preIdx]);
        
        curr.left = buildTree(preorder, inorder, inL, inIdx - 1, preIdx + 1);
        curr.right = buildTree(preorder, inorder, inIdx + 1, inR, preIdx + 1 + (inIdx - inL));
        return curr;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<inorder.length; i++) hm.put(inorder[i], i);
        
        return buildTree(preorder, hm, 0, inorder.length - 1, 0);
    }
}