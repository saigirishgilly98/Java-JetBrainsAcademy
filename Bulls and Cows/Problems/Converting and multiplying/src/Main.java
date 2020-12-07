import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = null;
        while (true) {
            try {
                inputString = scanner.next();
                int input = Integer.parseInt(inputString);
                if (input == 0) {
                    break;
                }
                System.out.println(input * 10);
            } catch (Exception e) {
                System.out.println("Invalid user input: " + inputString);
            }
        }
    }
}