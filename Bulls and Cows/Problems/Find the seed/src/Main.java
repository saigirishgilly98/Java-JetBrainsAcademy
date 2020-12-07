import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] pseudoRandomNumbers = new int[n];
        int[] maxArray = new int[b - a + 1];
        int index = 0;
        for (int i = a; i <= b; i++) {
            Random random  = new Random(i);
            for (int j = 0; j < n; j++) {
                pseudoRandomNumbers[j] = random.nextInt(k);
            }
            maxArray[index++] = maxOfArray(pseudoRandomNumbers);
        }
        int minIndex = minIndexOfArray(maxArray);
        System.out.println(minIndex + a);
        System.out.println(maxArray[minIndex]);
    }

    public static int minIndexOfArray(int[] array) {
        int min = array[0];
        int minIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int maxOfArray(int[] array) {
        int max = array[0];
        for (int i: array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}