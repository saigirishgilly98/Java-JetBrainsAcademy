import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int n = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        if (n >= str.length()) {
            System.out.println(str);
        } else {
            for (int i = n; i < str.length(); i++) {
                result.append(str.charAt(i));
            }
            for (int i = 0; i < n; i++) {
                result.append(str.charAt(i));
            }
            System.out.println(result);
        }
    }
}