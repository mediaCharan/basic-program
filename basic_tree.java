import java.util.Scanner;
import java.util.Stack;

import javax.xml.transform.stream.StreamSource;

import java.util.LinkedList;
import java.util.Queue;
 
class node{
    int data;
    node left;
    node right;
    node(int data){
        this.data=data;
        this.left = null;
        this.right = null;
    }
}
public class basic_tree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<node> q = new LinkedList<>();
        System.out.println("enter nodes");
        node root = new node(sc.nextInt());
        q.add(root);

        while(!q.isEmpty()) {
            node curr = q.poll();
            node cleft = new node(sc.nextInt());
            node cright = new node(sc.nextInt());

            curr.left = cleft;
            curr.right = cright;

            if(cleft.data!=-1) {
                q.add(cleft);
            }
            if(cright.data!=-1) {
                q.add(cright);
            }
        }

        printAll(root);
        System.out.println();
        System.out.println("preorder");
        preorder(root);
        System.out.println();
         System.out.println("inorder");
        inorder(root);
        System.out.println();
         System.out.println("postorder");
        postorder(root);
        System.out.println();
        System.out.println("BFS:");
        bfs(root);
        System.out.println();
        System.out.println("DFS:");
        dfs(root);
        System.out.println();
        System.out.println("Remove element:");
        delete_element(2,root);
        bfs(root);
        sc.close();
    }

    public static void printAll(node root) {
        System.out.print(root.data+" ");
        if(root.data!=-1) {
        printAll(root.left);
        printAll(root.right);
        }
    }

    public static void preorder(node root){
        if(root.data == -1){
            return ;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);

    }
    public static void postorder(node root){
        if(root.data == -1){
            return ;
        }
        
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");

    }
    public static void inorder(node root){
        if(root.data == -1){
            return ;
        }
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);

    }

    public static void bfs(node root) {
        Queue<node> que=new LinkedList<>();
        que.add(root);
        while(! que.isEmpty()){
            node curr=que.poll();
            System.out.print(curr.data+" ");
            if(curr.data != -1) {
                que.add(curr.left);
                que.add(curr.right);
            }
        }
    }
    public static void dfs(node root) {
        System.out.print(root.data+" ");
        if (root.data != -1){
            dfs(root.left);
            dfs(root.right);
        }
    }

        public static node delete_element(int key,node root) {
            if (root.data == -1){
                return root;
            }
            if (root.data !=  key){
                root.left=delete_element(key,root.left);
                root.right=delete_element(key,root.right);
                return root;
            }
            if (root.left.data == -1 && root.right.data == -1){
                return new node(-1);
            }
            else if (root.left.data == -1){
                return root.right;
            }
            else if (root.right.data == -1){
                return root.left;
            }
            else{
                node right_min=find_right_min(root.right);
                root.data=right_min.data;
                root.right=delete_element(right_min.data, root.right);
            }
            return root;

        }
        public static node find_right_min(node root) {
            if (root.left.data == -1){
                return root;
            }
            return find_right_min(root.left);
        }


    

}
