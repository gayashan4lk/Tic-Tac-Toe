import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        int max = 0;

        do{
            number = sc.nextInt();
            if(number > max){
                max = number;
            }
        }while (number != 0);
            System.out.println(max);

    }
}