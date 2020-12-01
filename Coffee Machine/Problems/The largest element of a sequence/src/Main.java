import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        int maxNumber = 0;
        do {
            number = scanner.nextInt();
            if (number > maxNumber) {
                maxNumber = number;
            }
        } while (number != 0);
        System.out.println(maxNumber);
    }
}