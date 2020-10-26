import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int total = 0;

        for(; a<=b; a++){
            total = total + a;
        }
        System.out.println(total);
    }
}