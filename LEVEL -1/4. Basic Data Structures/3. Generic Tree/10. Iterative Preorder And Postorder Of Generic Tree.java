//Ques->https://www.pepcoding.com/resources/online-java-foundation/generic-tree/iterative-preorder-postorder-generic-tree-official/ojquestion

//Code->
import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
static class Pair{
Node node;
int state;
Pair(Node node,int state)
{
  this.node=node;
  this.state=state;
}
}

  public static void IterativePreandPostOrder(Node node) {
    // write your code here
    Stack<Pair> stk=new Stack<>();
    stk.push(new Pair(node,-1));
    String pre="";
    String post="";
    while(stk.size()>0)
    {
      Pair top=stk.peek();
      if(top.state==-1)
      {
        pre+=top.node.data+" ";
        // System.out.println(pre);
        top.state++;

      }else if(top.state==top.node.children.size())
      {
        post+=top.node.data+" ";
        stk.pop();
      }
      else{
        Pair cp=new Pair(top.node.children.get(top.state),-1);
        stk.push(cp);
        top.state++;
      }
    }
    System.out.println(pre);
    System.out.println(post);

  }


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    IterativePreandPostOrder(root);
  }

}