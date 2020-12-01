import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int firstDigit = number % 10;
        number = number / 10;
        int secondDigit = number % 10;
        number = number / 10;
        int thirdDigit = number % 10;
        int sumOfDigits = firstDigit + secondDigit + thirdDigit;
        System.out.println(sumOfDigits);
    }
}