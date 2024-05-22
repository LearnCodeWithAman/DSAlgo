package stack;

import java.util.Iterator;

class Stack implements Iterable<Integer>{

    private int[] arr;
    private int top;
    private int capacity;


    public Stack(int size) {

        capacity = size;
        arr = new int[capacity];
        top = -1;
    }

    //insert an element in the stack
    public void push(int x) {

        if(isFull()) {
            System.out.println("Stack Overflow");
        }
        //System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    //remove an element from the stack
    public int pop() {

        if(isEmpty()) {
            System.out.println("STACK EMPTY");
            return -1;
        }
        return arr[top--];
    }

    //get the size of stack
    public int size() {
        return top+1;
    }

    //check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    //check if stack is full to its capacity
    public boolean isFull() {
        return top == capacity - 1;
    }

    //print the stack
    public void printStack() {

        System.out.println("Printing the Stack");
        if(isEmpty())
            System.out.println("STACK EMPTY");

        for(int i=0; i<=top; i++)
            System.out.print(" " +arr[i]);
        System.out.println();
    }

    //get the top element in the stack
    public int peek() {

        if(isEmpty()) {
            System.out.println("STACK EMPTY");
            return -1;
        }
        return arr[top];
    }

    //check if an element is present in the stack or not
    public boolean contains(int x) {

        if(isEmpty()) {
            System.out.println("STACK EMPTY");
            return false;
        }

        for(int i=0; i<=top; i++)
            if(arr[i] == x)
                return true;

        return false;
    }


    //get the center element of the stack
    public int findCenter() {

        if(isEmpty()) {
            System.out.println("STACK EMPTY");
            return -1;
        }
        return arr[top/2];
    }

    //sort the stack
    public void sortStack() {

        if(!isEmpty()) {
            int x = pop();
            sortStack();
            sortedInsert(x);
        }
    }

    public void sortedInsert(int x) {

        if(isEmpty() || x>peek()) {
            push(x);
            return;
        }

        int temp = pop();
        sortedInsert(x);
        push(temp);
    }

    //reverse the stack
    public void reverse() {

        if(size() > 0) {

            int x = pop();
            reverse();

            insertAtBottom(x);
        }
    }

    public void insertAtBottom(int x) {

        if(isEmpty())
            push(x);
        else {

            int y = pop();
            insertAtBottom(x);

            push(y);
        }
    }

    //Iterate the Stack
    public void iterate() {

        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }

        System.out.println("Stack Iteration ----");
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

                return currentIndex < size();
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
