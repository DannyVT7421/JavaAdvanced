package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class Ex05LineNumbers {
    private static final String INPUT_PATH = "src/StreamsFilesAndDirectories/resources/inputLineNumbers.txt";
    private static final String OUTPUT_PATH = "src/StreamsFilesAndDirectories/resources/output.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {
            int number = 1;
            String line = reader.readLine();
            while (line != null) {
                writer.println(String.format("%d. %s", number, line));
                number++;
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
