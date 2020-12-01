import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfGrades = scanner.nextInt();
        int gradeA = 0, gradeB = 0, gradeC = 0, gradeD = 0;
        int grade;

        for (int i = 0; i < numberOfGrades; i++) {
            grade = scanner.nextInt();

            if (grade == 5) {
                gradeA++;
            } else if (grade == 4) {
                gradeB++;
            } else if (grade == 3) {
                gradeC++;
            } else if (grade == 2) {
                gradeD++;
            }
        }

        System.out.print(gradeD + " " + gradeC + " " + gradeB + " " + gradeA);
    }
}