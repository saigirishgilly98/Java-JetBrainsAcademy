import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfParts = scanner.nextInt();
        int partsReadyToBeShipped = 0;
        int partsToBeFixed = 0;
        int rejects = 0;
        int detectorPrints;
        for (int i = 0; i < numberOfParts; i++) {
            detectorPrints = scanner.nextInt();
            if (detectorPrints < 0) {
                rejects++;
            } else if (detectorPrints > 0) {
                partsToBeFixed++;
            } else {
                partsReadyToBeShipped++;
            }
        }
        System.out.println(partsReadyToBeShipped + " " + partsToBeFixed + " " + rejects);
    }
}