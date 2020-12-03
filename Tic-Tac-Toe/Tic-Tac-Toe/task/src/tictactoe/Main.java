package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] array = new char[9];
        for (int i = 0; i < 9; i++) {
            array[i] = ' ';
        }
        printMatrix(array);
        char[][] matrix = new char[3][3];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = array[index++];
            }
        }
        String inputX;
        String inputY;
        int counter = 0;
        while (true) {
            while (true) {
                System.out.println("Enter the coordinates:");
                inputX = scanner.next();
                inputY = scanner.next();
                if (!inputX.matches("\\d") || !inputY.matches("\\d")) {
                    System.out.println("You should enter numbers!");
                } else if (Integer.parseInt(inputX) > 3 || Integer.parseInt(inputX) < 1 || Integer.parseInt(inputY) > 3 || Integer.parseInt(inputY) < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (matrix[3 - Integer.parseInt(inputY)][Integer.parseInt(inputX) - 1] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    break;
                }
            }
            int arrayIndex = 3 * (3 - Integer.parseInt(inputY)) + (Integer.parseInt(inputX) - 1);
            if (counter % 2 == 0) {
                matrix[(3 - Integer.parseInt(inputY))][(Integer.parseInt(inputX) - 1)] = 'X';
                array[arrayIndex] = 'X';
            } else {
                matrix[(3 - Integer.parseInt(inputY))][(Integer.parseInt(inputX) - 1)] = 'O';
                array[arrayIndex] = 'O';
            }
            printMatrix(array);
            if(stateOfTheGame(array)) {
                break;
            }
            counter++;
        }
    }

    public static boolean stateOfTheGame(char[] array) {
        if (isDifferenceGreater(array) || isRowComplete(array) == 100 || isDiagonalComplete(array) == 100 || isColumnComplete(array) == 100 || isRowComplete(array) != -1 && isColumnComplete(array) != -1 || isRowComplete(array) != -1 && isDiagonalComplete(array) != -1 || isDiagonalComplete(array) != -1 && isColumnComplete(array) != -1) {
//            System.out.println("Impossible");
        } else if (isRowComplete(array) == -1 && isColumnComplete(array) == -1 && isDiagonalComplete(array) == -1 && isEmptyCellPresent(array)) {
//            System.out.println("Game not finished");
        } else if (isRowComplete(array) == -1 && isColumnComplete(array) == -1 && isDiagonalComplete(array) == -1 && !isEmptyCellPresent(array)) {
            System.out.println("Draw");
            return true;
        } else if (isRowComplete(array) != -1 || isColumnComplete(array) != -1 || isDiagonalComplete(array) != -1) {
            int winner = isRowComplete(array) != -1 ? isRowComplete(array) : isColumnComplete(array) != -1 ? isColumnComplete(array) : isDiagonalComplete(array);
            System.out.println(array[winner] + " wins");
            return true;
        }
        return false;
    }

    public static boolean isDifferenceGreater(char[] array) {
        int sumOfX = 0;
        int sumOfO = 0;
        for (char ch: array) {
            if (ch == 'X') {
                sumOfX++;
            } else if (ch == 'O') {
                sumOfO++;
            }
        }
        if (Math.abs(sumOfO - sumOfX) > 1) {
            return true;
        }
        return false;
    }

    public static int isRowComplete(char[] array) {
        int result = 0;
        if (array[0] == array[1] && array[1] == array[2] && array[0] != ' ') {
            result += 1;
        }
        if(array[3] == array[4] && array[4] == array[5] && array[3] != ' ') {
            result +=  3;
        }
        if(array[6] == array[7] && array[7] == array[8] && array[6] != ' ') {
            result += 6;
        }
        if (result == 1 || result == 3 || result == 6) {
            return result;
        } else if (result == 4 || result == 9 || result == 7) {
            return 100;
        }
        return -1;
    }

    public static int isColumnComplete(char[] array) {
        int result = 0;
        if (array[0] == array[3] && array[3] == array[6] && array[0] != ' ') {
            result += 3;
        }
        if(array[1] == array[4] && array[4] == array[7] && array[1] != ' ') {
            result += 1;
        }
        if(array[2] == array[5] && array[5] == array[8] && array[2] != ' ') {
            result += 5;
        }
        if (result == 3 || result == 1 || result == 5) {
            return result;
        } else  if (result == 4 || result == 8 || result == 6) {
            return 100;
        }
        return -1;
    }

    public static int isDiagonalComplete(char[] array) {
        int result = 0;
        if (array[0] == array[4]  && array[4] == array[8] && array[0] != ' ') {
            result += 4;
        }
        if (array[2] == array[4] && array[4] == array[6] && array[2] != ' ') {
            result += 2;
        }
        if (result == 4 || result == 2) {
            return result;
        } else if (result == 6){
            return 100;
        }
        return -1;
    }

    public static boolean isEmptyCellPresent(char[] array) {
        for (char ch: array) {
            if (ch == ' ') {
                return(true);
            }
        }
        return(false);
    }

    public static void printMatrix(char[] array) {
        int index = 0;
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(array[index] + " ");
                index++;
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
