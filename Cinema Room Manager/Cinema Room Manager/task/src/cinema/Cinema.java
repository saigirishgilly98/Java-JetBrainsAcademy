package cinema;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int columns = scanner.nextInt();
        char[][] matrix = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = 'S';
            }
        }
        while (true) {
            System.out.println("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            int option = scanner.nextInt();
            if (option == 0) {
                break;
            } else if (option == 1) {
                printMatrix(matrix, rows, columns);
            } else if (option == 2) {
                int row;
                int column;
                while (true) {
                    System.out.println("Enter a row number:");
                    row = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    column = scanner.nextInt();
                    if (row < 1 || row > rows || column < 1 || column > columns) {
                        System.out.println("Wrong input!");
                    } else if (matrix[row - 1][column - 1] == 'B') {
                        System.out.println("That ticket has already been purchased");
                    } else {
                        break;
                    }
                }
                System.out.println("Ticket price: $" + ticketPrice(rows, columns, row));
                matrix[row - 1][column - 1] = 'B';
            } else if (option == 3) {
                printStatistics(matrix, rows, columns);
            }
        }
    }

    public static void printStatistics(char[][] matrix, int rows, int columns) {
        int numberOfPurchasedTickets = numberOfPurchasedTickets(matrix, 0, rows, columns);
        int currentIncome = currentIncome(matrix, rows, columns);
        int totalIncome = totalIncome(rows, columns);
        float percentage;
        percentage = ((float) numberOfPurchasedTickets / (rows * columns)) * 100;
        System.out.printf("Number of purchased tickets: %d%n" +
                "Percentage: %.2f%%" + "%n" +
                "Current income: $%d%n" +
                "Total income: $%d%n", numberOfPurchasedTickets, percentage, currentIncome, totalIncome);
    }

    public static int numberOfPurchasedTickets(char[][] matrix, int startRows, int rows, int columns) {
        int numberOfPurchasedTickets = 0;
        for (int i = startRows; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 'B') {
                    numberOfPurchasedTickets++;
                }
            }
        }
        return numberOfPurchasedTickets;
    }

    public static int currentIncome(char[][] matrix, int rows, int columns) {
        int income;
        if(rows * columns <= 60) {
            income = numberOfPurchasedTickets(matrix, 0, rows, columns) * 10;
        } else {
            income = numberOfPurchasedTickets(matrix, 0, rows / 2, columns) * 10 + numberOfPurchasedTickets(matrix, (rows - rows / 2) - 1, rows, columns) * 8;
        }
        return income;
    }

    public static int ticketPrice(int rows, int columns, int row) {
        if (rows * columns < 60) {
            return 10;
        } else if (row <= rows / 2) {
            return 10;
        }
        return 8;
    }

    public static void printMatrix(char[][] matrix, int rows, int columns) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= columns; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < columns; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int totalIncome(int rows, int columns) {
        int profit;
        if(rows * columns <= 60) {
            profit = rows * columns * 10;
        } else {
            profit = ((rows / 2) * columns * 10) + (rows - rows / 2) * columns * 8;
        }
        return profit;
    }
}