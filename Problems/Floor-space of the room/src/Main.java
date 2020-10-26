import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String roomShape = scanner.next();
        double areaOfRoom = 0;

        switch (roomShape){
            case "triangle":
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();
                double s = (a + b + c)/2;
                areaOfRoom = Math.sqrt(s*(s - a)*(s - b)*(s - c));
                break;

            case "rectangle":
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                areaOfRoom = x*y;
                break;

            case "circle":
                double r = scanner.nextDouble();
                areaOfRoom = 3.14*(r*r);
                break;

            default:
                System.out.println("This is not a shape of a room!");
                break;
        }
        System.out.println(areaOfRoom);
    }
}