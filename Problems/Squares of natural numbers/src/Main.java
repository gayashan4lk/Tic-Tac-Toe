import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long sq = 1;
        int i=1;
        while (N >= sq) {
            sq = i*i;
            i++;
            if (N >= sq) {
                System.out.println(sq);
            }
        }
    }
}