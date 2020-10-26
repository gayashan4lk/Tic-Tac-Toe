import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = 0;

        while (sc.nextInt() != 0) {
            counter++;
        }

        System.out.print(counter);
    }
}