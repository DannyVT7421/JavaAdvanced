package DefiningClasses.Ex06PokemonTrainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trainer {
    //name, number of badges and a collection of pokemon
    private String name;
    private int badge;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badge = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getBadge() {
        return badge;
    }

    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon) {
        this.pokemons.remove(pokemon);
    }

    public boolean hasPokemon(List<Pokemon> pokemons, String element) {
        boolean hasPokemon = false;
        for (Pokemon p : this.pokemons) {
            if (p.getElement().equals(element)) {
                hasPokemon = true;
            }
        }
        return hasPokemon;
    }

    public void increaseBadge() {
        this.badge++;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.badge, this.pokemons.size());
    }
}