import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        if (x1 == x2 || y1 == y2 || Math.abs(x2 - x1) == Math.abs(y2 - y1)) {
            System.out.println("YES");
        } else {
            System.out.println("NOJt");
        }
    }
}