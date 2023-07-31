import java.nio.file.FileSystem;

class dp_fib{
    public static int fib(int n,int[] arr) {
        if (n==1 || n==2){
            return n;
        }
        if (arr[n] == -1){
            arr[n]=fib(n-1,arr)+ fib(n-2,arr);
        }
        return arr[n];

    }
    public static void main(String[] args) {
        int arr[]=new int[11];
        int ans= fib(5,arr);
        System.out.println(ans);
        
    }
}