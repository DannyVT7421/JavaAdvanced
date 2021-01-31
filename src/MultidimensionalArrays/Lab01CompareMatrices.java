package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Lab01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner, "\\s+");
        int[][] secondMatrix = readMatrix(scanner, "\\s+");

        boolean areNotEqual = firstMatrix.length != secondMatrix.length;


        if (!areNotEqual) {
            for (int row = 0; row < firstMatrix.length; row++) {
                int[] firstArr = firstMatrix[row];
                int[] secondArr = secondMatrix[row];
                areNotEqual = firstArr.length != secondArr.length;
                if (!areNotEqual) {
                    for (int col = 0; col < firstArr.length; col++) {
                        if (firstArr[col] != secondArr[col]) {
                            areNotEqual = true;
                            break;
                        }
                    }
                }
                if (areNotEqual) {
                    break;
                }
            }
        }

        String output = areNotEqual ? "not equal" : "equal";
        System.out.println(output);
//        printMatrix(firstMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(Scanner scanner, String pattern) {
        int[] rowsAndCols = readArray(scanner, pattern);
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = readArray(scanner, pattern);
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
