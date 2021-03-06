//https://leetcode.com/problems/gas-station/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int extra=0,start=0,deficit=0;
        for(int i=0;i<gas.length;i++)
        {
            extra=extra+(gas[i]-cost[i]);
            if(extra<0)
            {
                start=i+1;
                deficit-=extra;
                extra=0;
            }
        }
        if(extra>=deficit) return start;
        return -1;
    }
}