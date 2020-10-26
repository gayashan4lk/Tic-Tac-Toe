import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        double denominator = 0;
        double numerator = 0;
        double average= 0;

        for (; a<=b; a++) {
            if (a%3 == 0) {
                denominator = denominator + 1;
                numerator = numerator + a;
            }
        }
        average = numerator / denominator;
        System.out.println(average);
    }
}