package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Ex06WordCount {
    private static final String WORDS_INPUT_PATH = "src/StreamsFilesAndDirectories/resources/words.txt";
    private static final String TEXT_INPUT_PATH = "src/StreamsFilesAndDirectories/resources/text.txt";
    private static final String OUTPUT_PATH = "src/StreamsFilesAndDirectories/resources/results.txt";

    public static void main(String[] args) {
        try (BufferedReader wordsReader = new BufferedReader(new FileReader(WORDS_INPUT_PATH));
                BufferedReader textReader = new BufferedReader(new FileReader(TEXT_INPUT_PATH));
                PrintWriter writer = new PrintWriter(OUTPUT_PATH)) {
            String[] words = wordsReader.readLine().split("\\s+");
            Map<String, Integer> wordOccurances = new HashMap<>();
            for (String word : words) {
                wordOccurances.put(word,0);
            }
            String[] text = textReader.readLine().split("\\s+");
            for (String s : text) {
                if(wordOccurances.containsKey(s)){
                    wordOccurances.put(s, wordOccurances.get(s) + 1);
                }
            }
            wordOccurances
                    .entrySet()
                    .stream()
                    .sorted((f,s)-> s.getValue().compareTo(f.getValue()))
                    .forEach(s->writer.println(String.format("%s - %d", s.getKey(), s.getValue())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
