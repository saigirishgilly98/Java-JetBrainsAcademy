import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int maxElement = array[0];
        int maxIndex = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] > maxElement) {
                maxElement = array[i];
                maxIndex = i;
            }
        }
        System.out.println(maxIndex);
    }
}