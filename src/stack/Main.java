package stack;

public class Main {

    public static void main(String args[]) {

        Stack stack = new Stack(10);

        stack.push(12);
        stack.push(21);
        stack.push(7);
        stack.push(10);
        stack.push(3);

        stack.printStack();

        stack.pop();
        stack.printStack();
        stack.push(0);
        stack.printStack();

        int x = 2;
        boolean contains = stack.contains(x);
        System.out.println("Stack contains " + x + ": " + contains);

        int center = stack.findCenter();
        System.out.println("Element at the center : " + center);

        System.out.println("Sorting the Stack");
        stack.sortStack();
        stack.printStack();

        stack.pop();
        stack.printStack();

        System.out.println("Reversing the Stack");
        stack.reverse();
        stack.printStack();

        stack.push(0);
        stack.printStack();

        stack.iterate();
    }
}
