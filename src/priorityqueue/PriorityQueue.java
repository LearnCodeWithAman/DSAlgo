package priorityqueue;

import java.util.Iterator;

public class PriorityQueue implements Iterable<Task>{


    Task[] task;
    private int size, capacity;

    public PriorityQueue(int capacity) {

        this.capacity = capacity;
        task = new Task[this.capacity];
        size = -1;
    }



    public int size() {
        return size+1;
    }

    public boolean isEmpty() {
        return size<=0;
    }

    public boolean isFull() {
        return size == capacity-1;
    }

    //insert an element in the queue
    public void enqueue(int value, int priority) {

        size++;
        Task t = new Task(value, priority);
        task[size] = t;
    }

    //Get the highest priority element
    public int peek() {

        int highestPriority = Integer.MIN_VALUE;
        int px = -1;

        for(int i=0; i<=size; i++) {

            if(highestPriority == task[i].priority
                    && px > -1
                    && task[px].value < task[i].value) {
                highestPriority = task[i].priority;
                px = i;
            }
            else if(highestPriority < task[i].priority) {
                highestPriority = task[i].priority;
                px = i;
            }
        }

        return px;
    }

    //remove the highest priority element
    public void dequeue() {

        int px = peek();

        for(int i=px; i<size; i++)
            task[i] = task[i+1];

        size--;
    }

    //Traverse the Priority Queue
    public void print() {

        System.out.println("Printing the Priority Queue:");

        if(isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        for(int i=0; i<=size; i++)
            System.out.println(task[i].toString());
    }

    //Check if element is present in the Queue
    public boolean contains(int value) {

        for(int i=0; i<=size; i++) {
            if(task[i].value == value)
                return true;
        }
        return false;
    }

    //Sort the Queue by priority
    public void sort() {

        Task[] sorted = new Task[capacity];
        int i =0;
        int s=size;
        while(size>=0) {
            sorted[i] = task[peek()];
            dequeue();
            i++;
        }

        task = sorted;
        size = s;
    }

    //Get the center element of the Queue by priority
    public Task center() {

        return task[(size)/2];
    }

    //Reverse the Priority Queue by priority
    public void reverse() {

        sort();

        Task[] reverse = new Task[capacity];
        Task t1, t2, t3;

        for(int i=0; i<=size; i++) {

            t1 = task[i];
            t2 = task[size-i];
            t3 = new Task(t2.value, t1.priority);

            reverse[i] = t3;
        }
        task = reverse;
    }

    //Iterate the Priority Queue
    public void iterate() {

        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println("Queue Iteration ----");
        Iterator<Task> iterator = iterator();

        while(iterator.hasNext())
            System.out.println(iterator.next().toString());
    }

    @Override
    public Iterator<Task> iterator() {

        Iterator<Task> iterator = new Iterator<Task>() {

            int currentIndex = 0;

            @Override
            public boolean hasNext() {

                return currentIndex < size();
            }

            @Override
            public Task next() {

                if(hasNext())
                    return task[currentIndex++];
                return null;
            }
        };
        return iterator;
    }
}