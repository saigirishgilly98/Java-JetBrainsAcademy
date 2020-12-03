import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int element = scanner.nextInt();
        boolean isElementPresent = false;
        for (int ele: array) {
            if (ele == element) {
                isElementPresent = true;
                break;
            }
        }
        if (isElementPresent) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}