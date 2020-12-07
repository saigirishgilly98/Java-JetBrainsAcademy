package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        String lengthOfTheSecretCodeString = scanner.next();
        int lengthOfTheSecretCode = 0;
        boolean isValid = true;
        try {
            lengthOfTheSecretCode = Integer.parseInt(lengthOfTheSecretCodeString);
        } catch (Exception e) {
            isValid = false;
            System.out.println("Error: \"" + lengthOfTheSecretCodeString + "\" isn't a valid number.");
        }
        if (isValid) {
            if (lengthOfTheSecretCode <= 0 || lengthOfTheSecretCode > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            } else {
                System.out.println("Input the number of possible symbols in the code:");
                int numberOfPossibleSymbols = scanner.nextInt();
                if (numberOfPossibleSymbols < lengthOfTheSecretCode) {
                    System.out.println("Error: it's not possible to generate a code with a length of " + lengthOfTheSecretCode + " with " + numberOfPossibleSymbols + " unique symbols.");
                } else if (numberOfPossibleSymbols > 36) {
                    System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                } else {
                    String secretCode = generateSecretCode(lengthOfTheSecretCode, numberOfPossibleSymbols);
                    printGrade(secretCode);
                }
            }
        }
    }

    public static String generateSecretCode(int lengthOfTheSecretCode, int numberOfPossibleSymbols) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.print("The secret is prepared: ");
        for (int i = 0; i < lengthOfTheSecretCode; i++) {
            System.out.print("*");
        }
        int numberOfLetters = 0;
        int numberOfDigits = numberOfPossibleSymbols;
        if (numberOfPossibleSymbols > 10) {
            numberOfLetters = numberOfPossibleSymbols - 10;
            numberOfDigits = 10;
            char finalSymbol = (char) ('a' + numberOfLetters - 1);
            System.out.println(" (0-9, a-" + finalSymbol + ").");
        } else {
            int finalNumber = numberOfDigits - 1;
            System.out.println(" (0-" + finalNumber);
        }
        String[] symbols = new String[numberOfPossibleSymbols];
        for (int i = 0; i < numberOfDigits; i++) {
            symbols[i] = "" + i;
        }
        for (int i = 0; i < numberOfLetters; i++) {
            symbols[10 + i] = "" + (char)(97 + i);
        }

        Random random = new Random();
        while (stringBuilder.length() < lengthOfTheSecretCode) {
            String currentChar = symbols[random.nextInt(numberOfPossibleSymbols)];
            if (!stringBuilder.toString().contains(currentChar)) {
                stringBuilder.append(currentChar);
            }
        }
        return stringBuilder.toString();
    }

    public static void printGrade(String secretCode) {
        System.out.println("Okay, let's start a game!");
        int index = 1;
        while (true) {
            System.out.println("Turn " + index);
            index++;
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();
            int bulls = 0;
            int cows = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == secretCode.charAt(i)) {
                    bulls++;
                } else {
                    for (int j = 0; j < secretCode.length(); j++) {
                        if (j != i && str.charAt(i) == secretCode.charAt(j)) {
                            cows++;
                            break;
                        }
                    }
                }
            }
            if (bulls == secretCode.length()) {
                System.out.println("Grade: " + bulls + " bulls");
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            }
            if (bulls == 0 && cows == 0) {
                System.out.println("Grade: None.");
            } else {
                System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s).");
            }
        }
    }
}

