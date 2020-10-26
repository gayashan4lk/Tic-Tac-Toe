import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        int arraySize = sc.nextInt();
        int[] arr = new int[arraySize];

        for(int i = 0; i<arraySize; i++){
            arr[i] = sc.nextInt();
        }

        int n = sc.nextInt();

        for(int i = 0; i<arraySize ; i++){
            if(arr[i] == n){
                counter++;
            }
        }

        System.out.println(counter);
    }
}