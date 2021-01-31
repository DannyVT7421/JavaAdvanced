package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Ex11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndCals = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = rowsAndCals[0];
        int cols = rowsAndCals[1];

        String[][] matrix = new String[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = scanner.nextLine().split("\\s+");
        }
        printReversedMatrixDiagonals(matrix);
    }

    private static void printReversedMatrixDiagonals(String[][] matrix) {

        int r = matrix.length - 1;
        int c = matrix[r].length - 1;

        while (c >= 0 && r >=0) {
            int innerR = r;
            int innerC = c;
            while (0 <= innerR && innerC < matrix[r].length) {
                System.out.print(matrix[innerR--][innerC++] + " ");
            }
            System.out.println();
            c--;
            if (c < 0) {
                c = 0;
                r--;
            }
        }
    }
}
