import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int neighboringSeatsRequired = scanner.nextInt();
        boolean isPresent = false;
        int sum = 0;
        int row = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m - neighboringSeatsRequired; j++) {
                for (int k = 0; k < neighboringSeatsRequired; k++) {
                    sum += matrix[i][j + k];
                }
                if (sum == 0) {
                    isPresent = true;
                    row = i + 1;
                    break;
                }
                sum = 0;
            }
            if (isPresent) {
                break;
            }
        }
        System.out.println(row);
    }
}