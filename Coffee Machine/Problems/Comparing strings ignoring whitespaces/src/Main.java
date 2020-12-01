import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();
        if (string1.replace(" ", "").equals(string2.replace(" ", ""))) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}