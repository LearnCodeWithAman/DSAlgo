package queue;

import java.util.Iterator;

class Queue implements Iterable<Integer>{

    private int[] arr;
    private int front, rear, capacity;
    private int currentIndex;

    public Queue(int size) {
        front = 0;
        rear = 0;
        capacity = size;
        arr = new int[capacity];
    }

    //Insert value in the Queue
    public void enqueue(int x) {

        if(isFull()) {
            System.out.println("Queue is full");
            return;
        }

        arr[rear] = x;
        rear++;
    }

    //Remove first element from the Queue
    public int dequeue() {

        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int remove = arr[front];

        for(int i=0; i<rear-1; i++)
            arr[i] = arr[i+1];

        if(rear < capacity)
            arr[rear] = 0;

        rear--;
        return remove;
    }


    public boolean isEmpty() {
        return rear==front;
    }

    public boolean isFull() {
        return rear==capacity;
    }

    public int size() {
        return rear;
    }


    //Traverse the Queue
    public void printQueue() {

        if(isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        for (int i=front; i<rear; i++)
            System.out.print(" " +arr[i]);
        System.out.println();
    }

    //Get the front element in the Queue
    public int peek() {

        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        else {
            return arr[front];
        }
    }

    //Check if a value is present in the Queue
    public boolean contains(int x) {

        if(isEmpty()) {
            System.out.println("Queue is empty");
            return false;
        }

        for (int i=front; i<rear; i++)
            if(arr[i] == x)
                return true;

        return false;
    }

    //Get the center element in the Queue
    public int center() {

        if(isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return rear;
    }

    //Sorting the queue
    public void sortQueue() {

        if(isEmpty())
            return;

        int temp = peek();
        dequeue();
        sortQueue();
        pushInQueue(temp, size());
    }

    public void pushInQueue(int temp, int qsize) {

        if (isEmpty() || qsize == 0) {
            enqueue(temp);
            return;
        }
        else if (temp <= peek()) {
            enqueue(temp);
            frontToLast(qsize);
        }
        else {
            enqueue(peek());
            dequeue();
            pushInQueue(temp,qsize-1);
        }
    }

    public void frontToLast(int qsize) {

        if(qsize <= 0)
            return;

        enqueue(peek());
        dequeue();

        frontToLast(qsize-1);
    }

    // Reverse the queue
    public void reverseQueue() {

        if(isEmpty())
            return;

        int front = dequeue();
        reverseQueue();
        enqueue(front);
    }

    //Iterate the Queue
    public void iterate() {

        if(isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println("Queue Iteration ----");
        Iterator<Integer> iterator = iterator();

        while(iterator.hasNext())
            System.out.println(iterator.next());
    }

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> iterator = new Iterator<Integer>() {

            int currentIndex = 0;

            @Override
            public boolean hasNext() {

                return currentIndex < rear;
            }

            @Override
            public Integer next() {

                if(hasNext())
                    return arr[currentIndex++];
                return null;
            }
        };
        return iterator;
    }
}
















