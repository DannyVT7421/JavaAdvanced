package MultidimensionalArrays;

import java.util.Scanner;

public class Ex01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = fillMatrix(n, pattern);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrix(int n, String pattern) {
        int[][] matrix = new int[n][n];
        switch (pattern){
            case "A":
                fillPatternA(matrix);
                break;
            case "B":
                fillPatternB(matrix);
                break;
        }
        return  matrix;
    }

    private static void fillPatternB(int[][] matrix) {

        int num = 1;
        for (int i = 0; i < matrix.length; i++) {
            if(i % 2 == 0){
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][i] = num ++;
                }
            }else{
                for (int j = matrix[i].length-1; j >=0 ; j--) {
                    matrix[j][i] = num ++;
                }
            }

        }
    }

    private static void fillPatternA(int[][] matrix) {
        int num = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[col][row] = num ++;
            }
            System.out.println();
        }
    }

}
