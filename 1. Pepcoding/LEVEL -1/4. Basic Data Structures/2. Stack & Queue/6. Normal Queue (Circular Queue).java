//Ques->https://www.pepcoding.com/resources/online-java-foundation/stacks-and-queues/normal-queue-official/ojquestion

//Code
import java.io.*;
import java.util.*;

public class Main {

  public static class CustomQueue {
    int[] data;
    int front;
    int rear;
    int size;

    public CustomQueue(int cap) {
      data = new int[cap];
      front = 0;
      size = 0;
      rear=0;
    }

    int size() {
      // write ur code here
      return size;
    }

    void display() {
      // write ur code here
      int counter=size();
      int idx=front;
      while(counter-->0)
      {
          System.out.print(data[idx]+" ");
          idx=(idx+1)%data.length;
      }
      System.out.println();
    }

    void add(int val) {
      // write ur code here
      if(size()==data.length)
      {
          System.out.println("Queue overflow");
          return;
      }
      data[rear]=val;
      size++;
      rear=(rear+1)%data.length;
    }

    int remove() {
      // write ur code here
         if(size()==0)
      {
          System.out.println("Queue underflow");
          return -1;
      }
      int val=data[front];
      size--;
      front=(front+1)%data.length;
      return val;
    }

    int peek() {
       // write ur code here
                if(size()==0)
      {
          System.out.println("Queue underflow");
          return -1;
      }
      return data[front];
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    CustomQueue qu = new CustomQueue(n);

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("add")){
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if(str.startsWith("remove")){
        int val = qu.remove();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("peek")){
        int val = qu.peek();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(qu.size());
      } else if(str.startsWith("display")){
        qu.display();
      }
      str = br.readLine();
    }
  }
}