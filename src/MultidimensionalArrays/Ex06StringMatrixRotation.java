package MultidimensionalArrays;

import java.util.*;

public class Ex06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] info = scanner.nextLine().split("[()]");
        String command = info[0];
        int degree = Integer.parseInt(info[1]);
        if (degree > 360) {
            degree %= 360;
        }

        int maxLength = 0;
        List<String> input = new ArrayList<>();
        String s;
        while (!(s = scanner.nextLine()).equals("END")) {
            input.add(s);
            int currentLength = s.length();
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        int rows = input.size();
        int cols = maxLength;
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < input.get(row).length()) {
                    matrix[row][col] = input.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        if (degree == 0) {
            printMatrix(matrix);
        } else if (degree == 90) {
            printMatrix90Degree(matrix, rows, cols);
        } else if (degree == 180) {
            printMatrix180Degree(matrix, rows, cols);
        } else if (degree == 270) {
            printMatrix270Degree(matrix, rows, cols);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printMatrix90Degree(char[][] matrix, int rows, int cols) {
        for (int col = 0; col < cols; col++) {
            for (int row = rows -1; row >=0 ; row--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printMatrix180Degree(char[][] matrix, int rows, int cols) {
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols-1; col >=0; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printMatrix270Degree(char[][] matrix, int rows, int cols) {
        for (int col = cols-1; col >=0 ; col--) {
            for (int row = 0; row < rows ; row++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}

