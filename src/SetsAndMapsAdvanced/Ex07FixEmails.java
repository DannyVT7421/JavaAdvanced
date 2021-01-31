package SetsAndMapsAdvanced;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> personalData = new LinkedHashMap<>();
        String regex = "\\.([us|uk|com]){2,3}\\b";
        Pattern pattern = Pattern.compile(regex);
        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            Matcher matcher = pattern.matcher(email);
            if (matcher.find()) {
                name = scanner.nextLine();
                continue;
            }
            if (personalData.get(name) == null) {
                personalData.put(name, email);
            } else {
                personalData.put(name, email);
            }
            name = scanner.nextLine();
        }
        personalData.entrySet().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}

