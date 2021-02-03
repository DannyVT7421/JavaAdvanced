package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Ex07MergeTwoFiles {
    private static final String INPUT_ONE_PATH = "src/StreamsFilesAndDirectories/resources/inputOne.txt";
    private static final String INPUT_TWO_PATH = "src/StreamsFilesAndDirectories/resources/inputTwo.txt";
    private static final String OUTPUT_PATH = "src/StreamsFilesAndDirectories/resources/results.txt";

    public static void main(String[] args) {
        try (BufferedReader firstReader = new BufferedReader(new FileReader(INPUT_ONE_PATH));
             BufferedReader secondReader = new BufferedReader(new FileReader(INPUT_TWO_PATH));
             PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {
            List<String> result = new ArrayList<>();
            String line = firstReader.readLine();
            while (line != null){
                writer.println(line);
                line= firstReader.readLine();
            }
            line = secondReader.readLine();
            while (line != null){
                writer.println(line);
                line= secondReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
