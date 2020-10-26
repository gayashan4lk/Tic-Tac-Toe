import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long input = sc.nextLong();
        int n = 0;
        long fac = 1;

        while(input>fac){
            fac = 1;
            for(int i =1; i<=n; i++){
                fac = fac*i;
            }

            System.out.print("n is: "+n);
            System.out.println(" | factorial is: "+fac);
            n++;

        }

        System.out.println("answer is: "+ n);
    }
}