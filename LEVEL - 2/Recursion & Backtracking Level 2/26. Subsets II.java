//https://leetcode.com/problems/subsets-ii/submissions/

class Solution {
  
    List<List<Integer>> ans = new ArrayList<>();
    
    public void subsets(int currentItem, ArrayList<Integer> unique, 
            HashMap<Integer, Integer> freq, List<Integer> res){
        if(currentItem == unique.size()){
            ans.add(new ArrayList<>(res));
            return;
        }
        
        int val = unique.get(currentItem);
        subsets(currentItem + 1, unique, freq, res); // no
        
        for(int f=0; f<freq.get(val); f++){
            res.add(val);
            subsets(currentItem + 1, unique, freq, res);
        }
        
        for(int f=0; f<freq.get(val); f++){
            res.remove(res.size() - 1);
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