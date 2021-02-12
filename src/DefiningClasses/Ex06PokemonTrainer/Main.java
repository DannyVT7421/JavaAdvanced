package DefiningClasses.Ex06PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        Trainer trainer = null;
        Pokemon pokemon;
        String line;
        while (!(line = scanner.nextLine()).equals("Tournament")) {
            String[] tokens = line.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).addPokemon(pokemon);
        }

        while (!(line = scanner.nextLine()).equals("End")) {
            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
                if (entry.getValue().getPokemons().size() > 0) {
                    if (entry.getValue().hasPokemon(entry.getValue().getPokemons(),line)) {
                        entry.getValue().increaseBadge();
                    } else {
                        for (Pokemon p : entry.getValue().getPokemons()) {
                            p.decreaseHealth();
                            if (p.getHealth() <= 0) {
                                entry.getValue().removePokemon(p);
                            }
                            if (entry.getValue().getPokemons().size() < 1) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (trainers != null) {
            trainers.entrySet().stream().sorted((f, s) -> Integer.compare(s.getValue().getBadge(), f.getValue().getBadge()))
                    .forEach(e -> System.out.println(e.getValue()));
        }
    }
}
