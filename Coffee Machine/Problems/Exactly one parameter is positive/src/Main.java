import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        boolean num1Positive = num1 > 0 && num2 <= 0 && num3 <= 0;
        boolean num2Positive = num1 <= 0 && num2 > 0 && num3 <= 0;
        boolean num3Positive = num1 <= 0 && num2 <= 0 && num3 > 0;
        boolean result = num1Positive || num2Positive || num3Positive;
        System.out.println(result);
    }
}