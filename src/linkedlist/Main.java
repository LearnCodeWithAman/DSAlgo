package linkedlist;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        LinkedList list = new LinkedList();

        list.insertNode(9);
        list.insertNode(43);
        list.insertNode(3);
        list.insertNode(12);
        list.insertNode(17);

        list.deleteNode(5);
        list.insertNode(8);
        list.insertAtPosition(0,5);
        list.deleteAtPosition(3);
        list.findCenter();

        list.reverse();
        System.out.println("Size of list: " +list.size());
        list.sort();

        list.iterate();

    }
}