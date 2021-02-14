package Generics.Ex08CustomListSorter;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T remove(int index) {
        return this.data.remove(index);
    }

    public long countGreaterThan(T element) {
        return this.data.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public void swap(int firstIndex, int secondIndex) {
        T first = this.data.get(firstIndex);
        this.data.set(firstIndex, this.data.get(secondIndex));
        this.data.set(secondIndex, first);
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public int size() {
        return this.data.size();
    }

    public T get(int index) {
        return this.data.get(index);
    }

    public T getMax() {
        T maxEl = this.data.get(0);
        for (T element : this.data) {
            if (element.compareTo(maxEl) > 0) {
                maxEl = element;
            }
        }
        return maxEl;
    }

    public T getMin() {
        T minEl = this.data.get(0);
        for (T element : this.data) {
            if (element.compareTo(minEl) < 0) {
                minEl = element;
            }
        }
        return minEl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T d : data) {
            sb.append(d.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
