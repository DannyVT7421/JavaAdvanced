package MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Ex07CrossfireWithList {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] rowsAndCols = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        ArrayList<ArrayList<Integer>> filled = new ArrayList<>();

        int counter = 1;
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                numbers.add(counter++);
            }
            filled.add(numbers);
        }

        String s;
        while (!(s = reader.readLine()).equals("Nuke it from orbit")) {
            int[] array = Arrays.stream(s.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int rowPos = array[0];
            int colPos = array[1];
            int rad = array[2];

            List<Integer> currentRow = filled.get(rowPos);
            for (int i = Math.max(0, colPos - rad); i <= Math.min(colPos + rad, currentRow.size() - 1); i++) {
                currentRow.set(i, -1);
            }

            for (int i = Math.max(0, rowPos - rad); i <= Math.min(rowPos + rad, filled.size() - 1); i++) {
                if (colPos < filled.get(i).size()) {
                    filled.get(i).set(colPos, -1);
                }
            }
            for (ArrayList<Integer> integers : filled) {
                removeNegativeValues(integers);
            }
        }
        printMatrix(filled);
    }

    private static void removeNegativeValues(ArrayList<Integer> currentRow) {
        while ((currentRow.contains(-1))) {
            currentRow.remove(currentRow.indexOf(-1));
        }
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> integers : matrix) {
            integers.stream().forEach(i -> System.out.println(i + " "));
//            for (Integer integer : integers) {
//                System.out.print(integer + " ");
//            }
            System.out.println();
        }
    }
}
//    private static List<List<Integer>> readMatrix(Scanner scanner, String pattern) {
//        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split(pattern))
//                .mapToInt(Integer::parseInt).toArray();
//        int rows = rowsAndCols[0];
//        int cols = rowsAndCols[1];
//        List<List<Integer>> matrix = new ArrayList<>();
//        for (int i = 0; i < rows; i++) {
//            List<Integer> list = Arrays.stream(scanner.nextLine().split(pattern))
//                    .map(Integer::parseInt)
//                    .collect(Collectors.toList());
//            matrix.add(list);
//        }
//
//        return matrix;
//    }

