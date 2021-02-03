package Workshop;

public class SmartArray {
    //    how to store the elements?
//    как външния код ще използва моят начин
    private int[] elements;
    private int size;

    public SmartArray() {
        this.elements = new int[8];
        this.size = 0;
    }

    public void add(int element) {
        if (this.elements.length==this.size) {
            int[] newElements = new int[this.size *2];
            System.arraycopy(this.elements, 0,
                    newElements, 0, this.elements.length);
            this.elements = newElements;
        }
        this.elements[this.size++] = element;
        }

    }

