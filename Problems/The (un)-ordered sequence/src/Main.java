import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nPrevious = 0;
        int nCurrent;
        boolean flag = true;
        boolean asc = false;
        boolean desc = false;

        while (true) {
            nCurrent = sc.nextInt();

            if (nCurrent != 0) {
                //check sequence
                if (nPrevious != 0) {
                    if (nCurrent != nPrevious) {
                        if (nCurrent > nPrevious) {
                            asc = true;
                        }
                        if (nCurrent < nPrevious) {
                            desc = true;
                        }

                    }
                }
                nPrevious = nCurrent;
            } else {
                break;
            }
        }
        if(asc == true && desc == true){
            flag = false;
        }
        System.out.println(flag);

    }
}

/*
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        boolean ascendingOrder = true;
        boolean descendingOrder = true;
        int prev = scanner.nextInt();
        int next;
        while (scanner.hasNextInt() && (next = scanner.nextInt()) != 0) {
            if (next > prev) {
                descendingOrder = false;
            } else if (prev > next) {
                ascendingOrder = false;
            }
            prev = next;
        }
        System.out.println(ascendingOrder || descendingOrder);
    }
}
 */