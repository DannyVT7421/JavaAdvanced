package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lab02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = readArray(scanner, "\\s+");
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int i = 0; i < tokens.length; i++) {
                int number = Integer.parseInt(tokens[i]);
                matrix[row][i] = number;
            }
        }
        int num = Integer.parseInt(scanner.nextLine());
        ArrayList<int[]> positions = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == num) {
                    int[] indexes = new int[]{row, col};
                    positions.add(indexes);
                }
            }
        }
        if (positions.isEmpty()) {
            System.out.println("not found");
        } else {
            for (int[] position : positions) {
                System.out.println(position[0] + " " + position[1]);
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
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
