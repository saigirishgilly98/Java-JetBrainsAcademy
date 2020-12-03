import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] array = new char[4][4];
        String input;
        for (int i = 0; i < 4; i++) {
            input = scanner.next();
            for (int j = 0; j < 4; j++) {
                array[i][j] = input.charAt(j);
            }
        }
        boolean isPretty = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] == array[i][j + 1] && array[i + 1][j] == array[i + 1][j + 1]
                        && array[i][j] == array[i + 1][j]) {
                    isPretty = false;
                    break;
                }
            }
        }
        if (isPretty) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}