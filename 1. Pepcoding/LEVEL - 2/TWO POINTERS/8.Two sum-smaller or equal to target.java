//ONlY Code
class Solution {
    public int maxOperations(int[] nums, int target) {
        Arrays.sort(nums);
          int left=0,right=nums.length-1;
        int count=0;
        while(left<right)
        {
            int sum=nums[left]+nums[right];
            if(sum<=target)
               {
               count+=right-left;
                left++;
               }
            else
            {

                right--;
            }
        }
    return count;
    }