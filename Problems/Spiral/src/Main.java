import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val = 1;
        int [][] spiral = new int[n][n];
        int mincol = 0;
        int maxcol = n-1;
        int minrow = 0;
        int maxrow = n-1;

        while (val <= n*n){
            for (int i = mincol ; i <= maxcol; i++ ){
                //System.out.println( "for1 => row: " + minrow + " column: " + i + " , val = "+val);
                spiral [minrow][i] = val++;
            }


            for (int i = minrow+1; i <= maxrow; i++){
                //System.out.println( "for2 => row: " + i + " column: " + maxcol + " , val = "+val);
                spiral [i][maxcol] = val++;
            }


            for (int i = maxcol-1; i >= mincol; i-- ){
                //System.out.println( "for3 => row: " + maxrow + " column: " + i + " , val = "+val);
                spiral [maxrow][i] = val++;
            }


            for (int i = maxrow-1; i >= minrow+1; i--){
                //System.out.println( "for4 => row: " + i + " column: " + mincol + " , val = "+val);
                spiral [i][mincol] = val++;
            }

            maxrow--;
            maxcol--;
            minrow++;
            mincol++;
/*             System.out.println( "maxrow = " +  maxrow);
            System.out.println( "minrow = " +  minrow);
            System.out.println( "maxcol = " +  maxcol);
            System.out.println( "mincol = " +  mincol);

 */

        }
        //spiral [minrow][mincol] = n*n;

        for(int i=0; i < n; i++){
            for(int j= 0; j < n; j++){
                System.out.print(spiral [i][j] + " ");
            }
            System.out.print("\n");
        }

    }
}