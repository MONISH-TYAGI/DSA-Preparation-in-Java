//Ques->https://leetcode.com/submissions/detail/692157932/

//Code
class Solution {
    public int rob(int[] nums) {
         if(nums.length==1)
            return nums[0];
        int prev=nums[0];
        int curr=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++)
        {
            int no=curr;
            int yes=nums[i]+prev;
            prev=curr;
            curr=Math.max(yes,no);
            
        }
        return curr;
        
    }
}