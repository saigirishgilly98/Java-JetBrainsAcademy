import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int minIndex = scanner.nextInt();
        int maxIndex = scanner.nextInt();
        System.out.println(string.substring(minIndex, maxIndex + 1));
    }
}