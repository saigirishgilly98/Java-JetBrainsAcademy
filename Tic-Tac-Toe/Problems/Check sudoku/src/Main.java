import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n * n][n * n];
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        boolean isSolved = true;
        int[] columnArray = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            if (!isCorrect(matrix[i])) {
                isSolved = false;
                break;
            }
        }
        for (int i = 0; i < n * n; i++) {
            for (int j = 0; j < n * n; j++) {
                columnArray[j] = matrix[j][i];
            }
            if (!isCorrect(columnArray)) {
                isSolved = false;
                break;
            }
        }
        int index;
        for (int i = 0; i <= n * n - n; i++) {
            for (int j = 0; j <= n * n - n; j++) {
                System.out.println(i + " " + j);
                index = 0;
                for (int k1 = i; k1 < i + n; k1++) {
                    for (int k2 = j; k2 < j + n; k2++) {
                        columnArray[index] = matrix[k1][k2];
                        index++;
                    }
                }
                if (!isCorrect(columnArray)) {
                    isSolved = false;
                    break;
                }
            }
        }
        if (isSolved) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean isCorrect(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] != i + 1) {
                return(false);
            }
        }
        return(true);
    }
}