//Ques->https://leetcode.com/problems/coin-change/

//Code
class Solution {
    //TC->O(amount*coins)
    //SC->O(amount*coins)
    public int coinChange(int[] coins, int amount) {
       
        int [][]dp=new int[amount+1][coins.length];
        for(int i=0;i<dp.length;i++)
        {
for(int j=0;j<dp[0].length;j++)
{
    dp[i][j]=-1;
}}
        int ans=memo(amount,0,coins,dp);
        if(ans==Integer.MAX_VALUE)
            return -1;
        return ans;
    }
    public int memo(int amount,int idx ,int []coins,int [][]dp){
        if(amount==0)
            return 0;
        if(idx==coins.length) return Integer.MAX_VALUE;
        if(dp[amount][idx]!=-1)
            return dp[amount][idx];
        int minCoins=Integer.MAX_VALUE;
        for(int coin=0;amount>=coins[idx]*coin;coin++)
        {
    int ans=memo(amount-coins[idx]*coin,idx+1,coins,dp);

        if(ans<Integer.MAX_VALUE)
            ans+=coin;
            
            minCoins=Math.min(minCoins,ans);
        }
            return dp[amount][idx]=minCoins;

         
    }
}