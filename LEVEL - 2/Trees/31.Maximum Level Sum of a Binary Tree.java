//https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

class Solution {
    public void DFS(TreeNode root, ArrayList<Integer> levelSum, int level){
        if(root == null) return;
        
        if(levelSum.size() > level) 
            levelSum.set(level, levelSum.get(level) + root.val);
        else levelSum.add(root.val);
        
        DFS(root.left, levelSum, level + 1);
        DFS(root.right, levelSum, level + 1);
    }
    public int maxLevelSum(TreeNode root) {
        ArrayList<Integer> levelSum = new ArrayList<>();
        levelSum.add(0);
        DFS(root, levelSum, 1);
        
        int maxSumLevel = 1;
        for(int i=1; i<levelSum.size(); i++){
            if(levelSum.get(i) > levelSum.get(maxSumLevel)){
                maxSumLevel = i;
            }
        }
        return maxSumLevel;
    }
}