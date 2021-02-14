package Generics.Ex06GenericCountMethodDoubles;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void addValue(T value) {
        this.values.add(value);
    }

    public void swap(int firstIndex, int secondIndex) {
        T first = this.values.get(firstIndex);
        this.values.set(firstIndex, this.values.get(secondIndex));
        this.values.set(secondIndex, first);
    }
    public long countGraterElements(T toCompare){
        return this.values.stream().filter(e -> e.compareTo(toCompare) > 0).count();
    }

    @Override
    public String toString() {
        StringBuilder sb =  new StringBuilder();
        for (T value : this.values) {
            sb.append(String.format("%s: %s",
                    value.getClass().getName(), value.toString() ))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
