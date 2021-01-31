package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class Lab06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < currentRow.length; col++) {
                matrix[row][col] = currentRow[col];
            }
        }
        int row = 0, col = 0;
        while (row < n && col < n) {
            System.out.print(matrix[row++][col++] + " ");
        }
        System.out.println();
        row = n - 1;
        col = 0;
        while (row >=0 && col <n){
            System.out.print(matrix[row--][col++] + " ");
        }
    }
}
