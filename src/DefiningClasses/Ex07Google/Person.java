package DefiningClasses.Ex07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Children> children;
    private List<Parents> parents;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.name).append(System.lineSeparator());
        sb.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            sb.append(company.toString()).append(System.lineSeparator());
        }
        sb.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            sb.append(car.toString()).append(System.lineSeparator());
        }
            sb.append("Pokemon:").append(System.lineSeparator());
            if (this.pokemons != null) {
                for (Pokemon pokemon : pokemons) {
                    sb.append(pokemon.toString()).append(System.lineSeparator());
                }
            }
            sb.append("Parents:").append(System.lineSeparator());
            if (this.parents != null) {
                for (Parents parent : parents) {
                    sb.append(parent.toString()).append(System.lineSeparator());
                }
            }
            sb.append("Children:").append(System.lineSeparator());
            if (this.children != null) {
                for (Children child : children) {
                    sb.append(child.toString()).append(System.lineSeparator());
                }
            }
        return sb.toString();
    }
}
