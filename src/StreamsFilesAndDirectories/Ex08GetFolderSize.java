package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;



public class Ex08GetFolderSize {
    private static final String DIR_PATH = "src/StreamsFilesAndDirectories/resources/Exercises Resources";
    private static final String OUTPUT_PATH = "src/StreamsFilesAndDirectories/resources/results.txt";

    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {

            File folder = new File(DIR_PATH);
            int size = 0;
            File[] files = folder.listFiles();
            if(files != null){
                for (File file : files) {
                    size += file.length();
                }
            }
            writer.println("Folder size: " + size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
