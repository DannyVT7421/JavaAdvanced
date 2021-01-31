package SetsAndMapsAdvanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phoneBook = new HashMap<>();
        String line;
        while (!(line = scanner.nextLine()).equals("search")) {
            String[] data = line.split("-");
            String name = data[0];
            String phoneNumber = data[1];
            if (!phoneBook.containsKey(name)) {
                phoneBook.put(name, phoneNumber);
            } else {
                String current = phoneBook.get(name);
                phoneBook.replace(name, current, phoneNumber);
            }
        }

        while (!(line = scanner.nextLine()).equals("stop")){
            String searchedName = line;
            if(phoneBook.containsKey(searchedName)){
                System.out.println(searchedName +" -> "+ phoneBook.get(searchedName));
            }else{
                System.out.println("Contact "+ searchedName +" does not exist.");
            }
        }
    }
}
