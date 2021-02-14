package Generics.Ex08CustomListSorter;

public class Sorter {
    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        for (int i = 0; i < list.size(); i++) {
            T currentElem = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (currentElem.compareTo(list.get(j)) > 0) {
                    list.swap(i, j);
                }
            }
        }
    }
}
