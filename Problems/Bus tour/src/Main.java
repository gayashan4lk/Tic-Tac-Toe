import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int noOfBridges = sc.nextInt();
        int[] bridgeHeight = new int[noOfBridges];
        boolean flag = false;
        int dangerBridge = 0;

        for(int i = 0; i < noOfBridges; i++ ){
            bridgeHeight[i] = sc.nextInt();
        }

        for(int j = 0; j< noOfBridges; j++){
            if(bridgeHeight[j] <= N){
                flag = true;
                dangerBridge = j+1;
                break;
            }else {
                flag = false;
                continue;
            }
        }

        if(flag == true){
            System.out.println("Will crash on bridge "+dangerBridge);
        }else{
            System.out.println("Will not crash");
        }

    }
}