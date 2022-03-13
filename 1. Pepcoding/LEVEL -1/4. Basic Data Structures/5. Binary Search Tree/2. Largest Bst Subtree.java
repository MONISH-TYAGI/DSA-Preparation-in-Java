//Ques->https://nados.io/question/largest-bst-subtree?zen=true

//Code
import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
  static class BSTTriplet{
    int min=Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;
    boolean isBST=true;
    Node lbstnode=null;
    int lbstsize=0;
  }
  static BSTTriplet isBST(Node node)
  {
    if(node==null)
    {
      return new BSTTriplet();
    
    }
    BSTTriplet lt=isBST(node.left);
    BSTTriplet rt=isBST(node.right);

    BSTTriplet mt=new BSTTriplet();
    mt.min=Math.min(node.data,Math.min(lt.min,rt.min));
    mt.max=Math.max(node.data,Math.min(lt.max,rt.max));
    boolean nibst=node.data>lt.max&&node.data<rt.min;
    mt.isBST=(lt.isBST==true)&&(rt.isBST==true)&&(nibst==true);
    if(mt.isBST==true)
    {
      mt.lbstnode=node;
      mt.lbstsize=lt.lbstsize+rt.lbstsize+1;
}else if(lt.lbstsize>rt.lbstsize)
{
  mt.lbstnode=lt.lbstnode;
  mt.lbstsize=lt.lbstsize;
}else 
{
  mt.lbstnode=rt.lbstnode;
  mt.lbstsize=rt.lbstsize;
}
return mt;
  }

  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    
    // write your code here
    BSTTriplet ans= isBST(root);
    System.out.println(ans.lbstnode.data+"@"+ans.lbstsize);
  }

}