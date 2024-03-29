//https://leetcode.com/problems/subsets-ii/submissions/

class Solution {
  
    List<List<Integer>> ans = new ArrayList<>();
    
    public void subsets(int lastItem, ArrayList<Integer> unique, HashMap<Integer, Integer> freq, List<Integer> res){
        ans.add(new ArrayList<>(res));
        
        for(int i=lastItem; i<unique.size(); i++){
            int val = unique.get(i);
            int oldFreq = freq.get(val);
            
            if(oldFreq > 0){
                freq.put(val, oldFreq - 1);
                res.add(val);
                
                subsets(i, unique, freq, res);
                
                res.remove(res.size() - 1);
                freq.put(val, oldFreq);
            }
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<Integer> unique = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for(int val: nums){
            if(freq.containsKey(val) == true){
                freq.put(val, freq.get(val) + 1);
            } else {
                freq.put(val, 1);
                unique.add(val);
            }
        }
        
        subsets(0, unique, freq, new ArrayList<>());
        return ans;
    }
}