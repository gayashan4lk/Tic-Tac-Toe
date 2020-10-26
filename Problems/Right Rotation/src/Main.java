import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" "); //Input the sequence
        int noOfRotations = sc.nextInt(); //Input number of Rotations
        int n = noOfRotations % arr.length;

        //System.out.println("Original Array was : " + Arrays.toString(arr));
        for(int i = 0; i < n; i++ ){
            String last = arr[arr.length-1];
            for(int j = arr.length-1; j>0; j--){
                arr[j] = arr[j-1];
                //System.out.println("i = " + i + ", j = "+ j + " > "+  Arrays.toString(arr));
            }
            arr[0] = last;
        }
        //System.out.println("New array : " + Arrays.toString(arr));

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}