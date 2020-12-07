import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String inputSubString = scanner.nextLine();
        int frequency = 0;
        for (int i = 0; i <= inputString.length() - inputSubString.length(); i++) {
            for (int j = 0; j < inputSubString.length(); j++) {
                if (inputSubString.charAt(j) != inputString.charAt(i + j)) {
                    break;
                }
                if (j == inputSubString.length() - 1) {
                    frequency++;
                    i += inputSubString.length() - 1;
                }
            }
        }
        System.out.println(frequency);
    }
}