package priorityqueue;

public class Main {

    public static void main(String[] args) {

        PriorityQueue pq = new PriorityQueue(100);

        pq.enqueue(3,4);
        pq.enqueue(8,5);
        pq.enqueue(9,1);
        pq.enqueue(2,2);
        pq.enqueue(4,3);


        pq.print();

        Task ptask = pq.task[pq.peek()];
        System.out.println("Peek Element: " + ptask.toString());

        System.out.println("Removing the peek element");
        pq.dequeue();
        System.out.println("Size = " +pq.size());
        pq.print();

        ptask = pq.task[pq.peek()];
        System.out.println("Peek Element: " + ptask.toString());


        System.out.println("Center element: " + pq.center());

        pq.reverse();
        pq.print();

        pq.iterate();
    }
}
