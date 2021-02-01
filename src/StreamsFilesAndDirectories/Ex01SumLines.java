package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex01SumLines {
    private static final String PATH = "src/StreamsFilesAndDirectories/resources/input.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line = reader.readLine();
            while(line != null){
                int sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }

                System.out.println(sum);
                line = reader.readLine();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}