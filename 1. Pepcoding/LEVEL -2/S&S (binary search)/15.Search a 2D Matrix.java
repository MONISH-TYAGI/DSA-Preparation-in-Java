//https://leetcode.com/problems/search-a-2d-matrix/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0;
        int n=matrix.length;
        int m=matrix[0].length;
        int high=m*n-1;
        while(low<=high)
        {
           int mid=low+((high-low)/2);
            int row=mid/m;
            int col=mid%m;
            if(matrix[row][col]==target)
                return true;
           else if(matrix[row][col]>target)
                high=mid-1;
            else if(matrix[row][col]<target)
                low=mid+1;
        }
        return false;
    }
}