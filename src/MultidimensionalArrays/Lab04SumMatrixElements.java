package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Lab04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner, ", ");
        int sum = Arrays.stream(matrix)
                .mapToInt(arr -> Arrays.stream((arr)).sum()).sum();
//        int sum = 0;
//        for (int[] arr : matrix) {
//            for (int number : arr) {
//                sum += number;
//            }
//        }
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);
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
