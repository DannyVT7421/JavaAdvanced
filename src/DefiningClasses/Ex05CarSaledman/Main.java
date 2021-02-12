package DefiningClasses.Ex05CarSaledman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Engine> engineMap = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String engModel = tokens[0];
            int engPower = Integer.parseInt(tokens[1]);
            Engine engine = null;
            if (tokens.length == 2) {
                engine = new Engine(engModel, engPower);
            } else if (tokens.length == 3) {
                if(tokens[2].matches("^\\d+$")){
                    int engDisplacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(engModel, engPower, engDisplacement);
                }else{
                    String engEfficiency = tokens[2];
                    engine = new Engine(engModel, engPower, engEfficiency);
                }
            } else if (tokens.length == 4) {
                int engDisplacement = Integer.parseInt(tokens[2]);
                String engEfficiency = tokens[3];
                engine = new Engine(engModel, engPower, engDisplacement, engEfficiency);
            }
            engineMap.putIfAbsent(engModel,engine);
        }

        List<Car> cars = new LinkedList<>();
        int m =  Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String carModel = tokens[0];
            Engine engine = engineMap.get(tokens[1]);
            Car car = null;
            if (tokens.length == 2) {
                car = new Car(carModel, engine);
            } else if (tokens.length == 3) {
                if(tokens[2].matches("^\\d+$")){
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(carModel, engine, weight);
                }else{
                    String color = tokens[2];
                    car = new Car(carModel, engine, color);
                }
            } else if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(carModel, engine, weight, color);
            }
            cars.add(car);
        }
        cars.forEach(c-> System.out.println(c));
    }
}
