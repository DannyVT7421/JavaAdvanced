package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[][] matrix = readMatrix(scanner, arr);
        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0, maxCol = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (sum > maxSum) {
                    maxSum = sum;
                    maxRow = row;
                    maxCol = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int row = maxRow; row < maxRow + 3; row++) {
            for (int col = maxCol; col < maxCol+3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(Scanner scanner, int[] arr) {

        int rows = arr[0];
        int cols = arr[1];
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
