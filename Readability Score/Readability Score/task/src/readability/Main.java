package readability;

import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File(args[0]);
        System.out.println("The text is:");
        try (Scanner scanner = new Scanner(file)) {
            String text;
            double words = 0;
            double sentences = 0;
            double characters = 0;
            double syllables = 0;
            double polysyllables = 0;
            String regex = "\\w+[.?!]";
            while (scanner.hasNext()) {
                text = scanner.next();
                System.out.print(text + " ");
                if (text.matches(regex)) {
                    sentences++;
                    syllables += syllables(text.substring(0, text.length() - 1));
                    polysyllables += polysyllables(text.substring(0, text.length() - 1));
                    words++;
                    characters += text.length();
                } else if (!scanner.hasNext()){
                    sentences++;
                    syllables += syllables(text);
                    polysyllables += polysyllables(text);
                    words++;
                    characters += text.length();
                } else {
                    syllables += syllables(text);
                    polysyllables += polysyllables(text);
                    words++;
                    characters += text.length();
                }
            }
            System.out.println("\n");
            printFirstResults(words, sentences, characters, syllables, polysyllables);
            System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
            String scoreType = scanner.next();
            printScore(characters, words, sentences, syllables, polysyllables, scoreType);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printScore(double characters, double words, double sentences, double syllables, double polysyllables, String scoreType) {
        double age1, age2, age3, age4;
        double averageAge = 0;
        System.out.println("\n");
        switch(scoreType) {
            case "all":
                age1 = ARI(characters, words, sentences);
                age2 = FK(words, sentences, syllables);
                age3 = SMOG(sentences, polysyllables);
                age4 = CL(characters, words, sentences);
                averageAge = (age1 + age2 + age3 + age4) / 4;
                break;
            case "ARI":
                age1 = ARI(characters, words, sentences);
                averageAge =age1;
                break;
            case "FK":
                age2 = FK(words, sentences, syllables);
                averageAge = age2;
                break;
            case "SMOG":
                age3 = SMOG(sentences, polysyllables);
                averageAge = age3;
                break;
            case "CL":
                age4 = CL(characters, words, sentences);
                averageAge = age4;
                break;
        }
        System.out.println();
        System.out.printf("This text should be understood in average by %.2f year olds.", averageAge);
    }

    public static double ARI(double characters, double words, double sentences) {
        double score = (4.71 * (characters / words)) + (0.5 * (words / sentences)) - 21.43;
        String age = calculateAge(score);
        System.out.printf("Automated Readability Index: %.2f (about %s year olds).", score, age);
        System.out.println();
        return Double.parseDouble(age);
    }

    public static double FK(double words, double sentences, double syllables) {
        double score = (0.39 * (words / sentences)) + (11.8 * (syllables / words)) - 15.59;
        String age = calculateAge(score);
        System.out.printf("Flesch–Kincaid readability tests: %.2f (about %s year olds).", score, age);
        System.out.println();
        return Double.parseDouble(age);
    }

    public static double SMOG(double sentences, double polysyllables) {
        double score = 1.043 * Math.sqrt(polysyllables * (30 / sentences)) + 3.1291;
        String age = calculateAge(score);
        System.out.printf("Simple Measure of Gobbledygook: %.2f (about %s year olds).", score, age);
        System.out.println();
        return Double.parseDouble(age);
    }

    public static double CL(double characters, double words, double sentences) {
        double L = (characters / words) * 100;
        double S = (sentences / words) * 100;
        double score = 0.0588 * L - 0.296 * S - 15.8;
        String age = calculateAge(score);
        System.out.printf("Coleman–Liau index: %.2f (about %s year olds).", score, age);
        System.out.println();
        return Double.parseDouble(age);
    }

    public static String calculateAge(double score) {
        String age = null;
        switch ((int) Math.ceil(score)) {
            case 1:
                age = "6";
                break;
            case 2:
                age = "7";
                break;
            case 3:
                age = "9";
                break;
            case 4:
                age = "10";
                break;
            case 5:
                age = "11";
                break;
            case 6:
                age = "12";
                break;
            case 7:
                age = "13";
                break;
            case 8:
                age = "14";
                break;
            case 9:
                age = "15";
                break;
            case 10:
                age = "16";
                break;
            case 11:
                age = "17";
                break;
            case 12:
                age = "18";
                break;
            case 13:
                age = "24";
                break;
            case 14:
                age = "24+";
                break;
        }
        return age;
    }

    public static void printFirstResults(double words, double sentences, double characters, double syllables, double polysyllables) {
        System.out.println("Words: " + (int) words);
        System.out.println("Sentences: " + (int) sentences);
        System.out.println("Characters: " + (int) characters);
        System.out.println("Syllables: " + (int) syllables);
        System.out.println("Polysyllables: " + (int) polysyllables);
    }

    public static boolean isVowel(char ch) {
        return (ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u') || (ch == 'y') || (ch == 'A') || (ch == 'E') || (ch == 'I') || (ch == 'O') || (ch == 'U') || (ch == 'Y');
    }

    public static int syllables(String word) {
        int count  = 0;
        int i;
        for (i = 0; i < word.length() - 1; i++) {
            if (isVowel(word.charAt(i)) && !isVowel(word.charAt(i + 1))) {
                count++;
            }
        }
        if (isVowel(word.charAt(i)) && word.charAt(i) != 'e') {
            count++;
        }
        if (count == 0) {
            count++;
        }
        return count;
    }

    public static int polysyllables(String word) {
        return syllables(word) > 2 ? 1 : 0;
    }
}
