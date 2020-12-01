import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int up = scanner.nextInt();
        int down = scanner.nextInt();
        float distance = up - down;
        int result = (int) Math.round(Math.ceil((height - up) / distance + 1));
        System.out.println(result);
    }
}