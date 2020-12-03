import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] income = new int[n];
        int[] taxPercent = new int[n];
        for (int i = 0; i < n; i++) {
            income[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            taxPercent[i] = scanner.nextInt();
        }
        float[] taxAmount = new float[n];
        for (int i = 0; i < n; i++) {
            taxAmount[i] = (taxPercent[i] / 100f) * income[i];
        }
        float maxAmount = taxAmount[0];
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (taxAmount[i] > maxAmount) {
                maxAmount = taxAmount[i];
                maxIndex = i;
            }
        }
        System.out.println(maxIndex + 1);
    }
}