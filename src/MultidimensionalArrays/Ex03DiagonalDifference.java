package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner, n, "\\s+");

        int primaryDiagonalSum = getPrimarySum(matrix);
        int secondaryDiagonalSum = getSecondarySum(matrix);
        int diff = Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
        System.out.println(diff);
    }

    private static int getSecondarySum(int[][] matrix) {
        int sum = 0;
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[row].length) {
            sum += matrix[row--][col++];
        }
        return sum;
    }

    private static int getPrimarySum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int[][] readMatrix(Scanner scanner, int n, String pattern) {
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            int[] arr = readArray(scanner, pattern);
            matrix[row] = arr;
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        int[] arr = Arrays.stream(scanner.nextLine().split(pattern))
                .mapToInt(Integer::parseInt).toArray();
        return arr;
    }
}
