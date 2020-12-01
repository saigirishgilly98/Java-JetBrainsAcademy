import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number, prevNumber = scanner.nextInt();
        int increasing = -1, result = 1;
        do {
            number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            if (number >= prevNumber && increasing == -1) {
                increasing = 1;
            } else if (number < prevNumber && increasing == -1){
                increasing = 0;
            }

            if (number > prevNumber && increasing == 0) {
                result = 0;
                break;
            } else if (number < prevNumber && increasing == 1) {
                result = 0;
                break;
            }
            prevNumber = number;
        } while (number != 0);

        if (result == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}