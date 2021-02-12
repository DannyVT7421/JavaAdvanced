package DefiningClasses.Ex07Google;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        Person person;
        String line;
        while (!(line = scanner.nextLine()).equals("End")) {
            String[] tokens = line.split("\\s+");
            person = new Person(tokens[0]);
            boolean hasPerson = false;
            for (Person currentPerson : people) {
                String name = currentPerson.getName();
                if (name.equals(tokens[0])) {
                    hasPerson = true;
                    person = currentPerson;
                    break;
                }
            }
            switch (tokens[1]) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    person.setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String type = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, type);
                    List<Pokemon> pokemons = person.getPokemons();
                    pokemons.add(pokemon);
                    person.setPokemons(pokemons);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Parents parent = new Parents(parentName, parentBirthday);
                    List<Parents> parents = person.getParents();
                    parents.add(parent);
                    person.setParents(parents);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Children child = new Children(childName, childBirthday);
                    List<Children> children = person.getChildren();
                    children.add(child);
                    person.setChildren(children);
                    break;
                case "car":
                    String model = tokens[2];
                    int speed = Integer.parseInt(tokens[3]);
                    Car car = new Car(model, speed);
                    person.setCar(car);
                    break;
            }
            if (!hasPerson) {
                people.add(person);
            }
        }
        String targetName = scanner.nextLine();
        for (Person p : people) {
            if (p.getName().equals(targetName)) {
                System.out.print(p.toString());
            }
        }
    }
}
