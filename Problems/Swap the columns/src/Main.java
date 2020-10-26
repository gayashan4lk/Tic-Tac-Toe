import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        int row = sc.nextInt();
        int [][] twoD = new int[col][row];

        for(int i=0; i < col; i++){
            for(int j= 0; j < row; j++){
                twoD [i][j] = sc.nextInt();
            }
        }

        int x = sc.nextInt();
        int y = sc.nextInt();

        /*
        for(int i = 0; i < twoD.length; i++){
            System.out.println(Arrays.toString(twoD[i]));
        }
         */

        for(int i = 0; i < twoD.length; i++){
            int elemX = twoD [i][x];
            int elemY = twoD [i][y];
            twoD [i][x] = elemY;
            twoD [i][y] = elemX;
        }

        for(int i=0; i < col; i++){
            for(int j= 0; j < row; j++){
                System.out.print(twoD [i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}