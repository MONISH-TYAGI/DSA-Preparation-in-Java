/*Ques->A unique number is a number that is divisible by every digit it contains.

For example, 128 is a unique number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0. A unique number is not allowed to contain the digit zero.

Given two integers left and right, return a list of all the unique numbers in the range [left, right].

Input Format

First line takes an Integer L,as left
Second line takes an Integer R,as right
Constraints

1 <= left <= right <= 10^4
Output Format

Print an array of uniqur numbers
Sample Input 0

1
22
Sample Output 0

1 2 3 4 5 6 7 8 9 11 12 15 22
Explanation 0

Input: left = 1, right = 22
Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
Sample Input 1

47
85
Sample Output 1

48 55 66 77
Explanation 1

Input: left = 47, right = 85
Output: [48,55,66,77]*/

//Code
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner scn=new Scanner(System.in);
    int left,right;
      left=scn.nextInt();
      right=scn.nextInt();
      for(int i=left;i<=right;i++)
      {
        if(isUnique(i))
          System.out.print(i+" ");
        }
    }
  public static boolean isUnique(int n)
  {
    int x=n;
    while(n>0)
    {
      int i=n%10;
      if(i==0)
        return false;
      if(x%i!=0)
        return false;
      n=n/10;
    }
    return true;
  }
}