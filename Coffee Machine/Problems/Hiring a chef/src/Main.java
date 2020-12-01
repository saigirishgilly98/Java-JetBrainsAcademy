import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        scanner.nextLine();
        scanner.nextLine();
        scanner.nextLine();
        String cuisinePreference = scanner.nextLine();
        System.out.print("The form for " + firstName + " is completed. ");
        System.out.print("We will contact you if we need a chef that cooks " + cuisinePreference + " dishes.");
    }
}