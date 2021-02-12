package WorkshopCustomLinkedList;


public class Main {
    public static void main(String[] args) {
        CustomLinkedList customLinkedList = new CustomLinkedList();

        for (int i = 0; i < 5; i++) {
            customLinkedList.addFirst(i + 1);
        }

        for (int i = 6; i < 10 ;i++){
            customLinkedList.addLast(i);
        }

        customLinkedList.forEach(e -> System.out.println(e));
    }
}
