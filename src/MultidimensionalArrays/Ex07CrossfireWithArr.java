package MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex07CrossfireWithArr {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String[][] matrix = fillInTheMatrix(reader,"\\s+");

        String s;
        while (!(s = reader.readLine()).equals("Nuke it from orbit")) {
            int[] array = Arrays.stream(s.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int rowPos = array[0];
            int colPos = array[1];
            int rad = array[2];

            destroyingCol(matrix, rowPos, colPos, rad);
            destroyingRow(matrix, rowPos, colPos, rad);
            deletingNullPos(matrix);
        }
        printMatrix(matrix);
    }

    private static String[][] fillInTheMatrix(BufferedReader reader, String pattern) throws IOException {
        int[] rowsAndCols = Arrays.stream(reader.readLine().split(pattern))
                .mapToInt(Integer::parseInt).toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        String[][] matrix = new String[rows][cols];
        int startNum = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = String.valueOf(startNum++);
            }
        }
        return matrix;
    }

    private static String[][] deletingNullPos(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(matrix[i]).filter(e -> e != null).toArray(String[]::new);
        }
        matrix = Arrays.stream(matrix).filter(e -> e.length > 0).toArray(String[][]::new);
        return matrix;
    }

    private static void destroyingRow(String[][] matrix, int rows, int cols, int rad) {
        for (int c = cols - rad; c <= cols + rad; c++) {
            if (isNiBound(matrix, rows, c)) {
                matrix[rows][c] = null;
            }
        }
    }

    private static void destroyingCol(String[][] matrix, int rows, int cols, int rad) {
        for (int r = rows - rad; r <= rows + rad; r++) {
            if (isNiBound(matrix, r, cols)) {
                matrix[r][cols] = null;
            }
        }
    }

    private static boolean isNiBound(String[][] matrix, int r, int c) {
        return (0 <= r && r < matrix.length && 0 <= c && c < matrix[r].length);
    }

    private static void printMatrix(String[][] matrix) {
        if (matrix != null) {
            for (int row = 0; row < matrix.length; row++) {
                Arrays.stream(matrix[row]).forEach(e -> System.out.print(e + " "));
                System.out.println();
            }
        }
    }
}
