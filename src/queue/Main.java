package queue;

public class Main {

    public static void main(String[] args) {

        Queue queue = new Queue(10);

        queue.enqueue(16);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(13);
        queue.enqueue(2);
        queue.printQueue();

        System.out.println("Sorting the Queue :-");
        queue.sortQueue();
        queue.printQueue();

        System.out.println("Reversing the Queue :-");
        queue.reverseQueue();
        queue.printQueue();

        queue.iterate();
    }
}
