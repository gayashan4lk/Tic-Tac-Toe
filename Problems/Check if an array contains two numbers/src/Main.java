import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrayLength = sc.nextInt();
        boolean flag = false;
        int[] arr = new int[arrayLength];

        for(int i = 0; i < arrayLength; i++){
            arr[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int m = sc.nextInt();

        //System.out.println(Arrays.toString(arr));

        for(int i = 0; i < arrayLength-1; i++){
            if(arr[i] == n && arr[i+1] == m ){
                flag = true;
                break;
            }
            if(arr[i] == m && arr[i+1] == n){
                flag = true;
                break;
            }
        }

        System.out.println(flag);
    }
}