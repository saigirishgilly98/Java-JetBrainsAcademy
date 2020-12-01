import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int count = 0;
        boolean stop = false;
        for (int i = 1;; i++) {
            for (int j = 0; j < i; j++) {
                if (count >= number) {
                    stop = true;
                    break;
                }
                System.out.print(i + " ");
                count++;
            }
            if (stop) {
                break;
            }
        }
    }
}