import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int duration = scanner.nextInt();
        int foodCost = scanner.nextInt();
        int flightCost = scanner.nextInt();
        int hotelCost = scanner.nextInt();
        int result = foodCost * duration + 2 * flightCost + hotelCost * (duration - 1);
        System.out.println(result);
    }
}