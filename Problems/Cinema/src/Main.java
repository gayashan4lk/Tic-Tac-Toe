import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int m = 0;

        int checker = sc.nextInt();
        if(checker<21){
            n = checker;
        }

        checker = sc.nextInt();
        if(checker<21){
            m = checker;
        }

        int [][] cinema = new int[n][m];
        int temp;
        int counter;
        int noOfRow = 0;

        for(int i = 0; i<n; i++ ){
            for(int j = 0; j<m; j++){
                cinema[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();

        for(int i = 0; i<n; i++ ){
            //System.out.println("Cycle i : " + i );
            counter = 0;
            for(int j = 0; j<m; j++){
                //System.out.println("Cycle j : " + j );
                 if(cinema[i][j] == 0){
                     counter++;
                     //System.out.println("counter : " + counter );
                 }

                if(k == counter){
                    noOfRow = i+1;
                    //System.out.println("No of Row : " + noOfRow );
                    break;
                }

                if(cinema[i][j] == 1){
                    counter = 0;
                    //System.out.println("counter is zero !");
                }
            }
            if( k== counter ){
                break;
            }
        }

        System.out.println(noOfRow);
/*
        for(int i=0; i < n; i++){
            for(int j= 0; j < m; j++){
                System.out.print(cinema [i][j] + " ");
            }
            System.out.print("\n");
        }
*/

    }
}