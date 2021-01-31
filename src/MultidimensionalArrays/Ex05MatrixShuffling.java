package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = readMatrix(scanner, "\\s+");
        boolean isValid = false;
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] indexes = command.split("\\s+");
            if (indexes.length == 5) {
                int firstRow = Integer.parseInt(indexes[1]);
                int firstCol = Integer.parseInt(indexes[2]);
                int secondRow = Integer.parseInt(indexes[3]);
                int secondCol = Integer.parseInt(indexes[4]);
                isValid = ifIndexesAreValid(matrix, firstRow, firstCol, secondRow, secondCol);
                if (indexes[0].equals("swap") && isValid) {
                    swapElements(matrix, firstRow, firstCol, secondRow, secondCol);
                    printMatrix(matrix);
                } else {
                    isValid = false;
                }
            } else {
                isValid = false;
            }
            if(!isValid){
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }

    private static String[][] swapElements(String[][] matrix, int firstRow, int firstCol, int secondRow, int secondCol) {
        String firstString = matrix[firstRow][firstCol];
        String secondString = matrix[secondRow][secondCol];
        matrix[firstRow][firstCol] = secondString;
        matrix[secondRow][secondCol] = firstString;
        return matrix;
    }

    private static boolean ifIndexesAreValid(String[][] matrix, int firstRow, int firstCol, int secondRow, int secondCol) {
        if (0 <= firstRow && firstRow < matrix.length
                && 0 <= secondRow && secondRow < matrix.length
                && 0 <= firstCol && firstCol < matrix[firstRow].length
                && 0 <= secondCol && secondCol < matrix[secondRow].length) {
            return true;
        }
        return false;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] readMatrix(Scanner scanner, String pattern) {
        int[] rowsAndCols = readArray(scanner, pattern);
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        String[][] matrix = new String[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = scanner.nextLine().split(pattern);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine()
                .split(pattern))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
