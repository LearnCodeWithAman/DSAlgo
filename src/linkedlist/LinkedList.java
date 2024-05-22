package linkedlist;

import java.util.Iterator;

class LinkedList implements Iterable<Node>{


    private int size = 0;
    private Node head = null;


    // insert a new node
    public void insertNode(int data) {

        Node newNode = new Node(data);
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {

            Node current = head;

            while (current.next != null) {

                current = current.next;
            }

            current.next = newNode;
        }
        size++;
        print();
    }

    // insert a node at any position
    public void insertAtPosition(int data, int position) {

        int pos = position;

        if (pos < 1 || pos > size + 1) {
            System.out.println("Invalid Position to insert a node");
            return;
        }

        if (pos == 1) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        } else {

            Node current = head;

            while (pos > 2) {

                current = current.next;
                pos--;
            }

            Node newNode = new Node(data);
            newNode.next = current.next;
            current.next = newNode;
            size++;
            System.out.println(data + " : inserted at position: " + position);
        }
        print();
    }


    // delete a node
    public void deleteNode(int key) {

        if (size == 0) {
            System.out.println("Key cannot be deleted : List is Empty");
            return;
        }

        Node current = head;
        Node prev = null;
        int prevSize = size;

        while (current != null) {

            if (current.data == key) {

                if (current == head) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                current = null;
                size--;
                System.out.println(key + " : deleted from the List");
                print();
                return;
            }

            prev = current;
            current = current.next;
        }
        if (size == prevSize)
            System.out.println(key + ": not found in the List");
    }


    // delete a node at any position
    public void deleteAtPosition(int position) {

        if (size == 0) {
            System.out.println("Node cannot be deleted : List is Empty");
            return;
        }

        Node current = head;
        Node prev = null;
        int pos = position;

        if (pos > size) {
            System.out.println("Invalid Position to remove a node");
            return;
        }

        if (pos == 1) {
            head = current.next;
        } else {

            while (pos > 1) {

                prev = current;
                current = current.next;
                pos--;
            }
            prev.next = current.next;
        }
        current = null;
        size--;
        System.out.println("Node deleted at position: " + position);
        print();
    }


    // find center of a list
    public void findCenter() {

        if (size == 0) {
            System.out.println("List is Empty");
            return;
        }

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
        }

        System.out.println("Value at the center node:" + slow.data);
    }


    // reverse a linked list
    public void reverse() {

        System.out.println("Reversing the Linked List");

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        print();
    }


    // find size of LinkedList
    public int size() {

        Node current = head;
        int size = 0;

        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }


    //traverse the list
    public void print() {

        Node current = head;

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        while (current != null) {
            System.out.print(" " + current.data);
            current = current.next;
        }
        System.out.println();
    }

    // sort a linkedList
    public void sort() {

        head  = mergeSort(head);
        System.out.println("Sorted List :-");
        print();
    }


    // Merge Sort
    public Node mergeSort(Node h) {

        if (h == null || h.next == null) {
            return h;
        }

        Node middle = getMiddle(h);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(h);
        Node right = mergeSort(nextOfMiddle);

        Node sortedList = sortedMerge(left, right);
        return sortedList;
    }

    public Node getMiddle(Node head) {

        if (head == null)
            return head;
        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {

            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node sortedMerge(Node a, Node b) {

        Node result = null;

        if (a == null)
            return b;
        if (b == null)
            return a;

        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    //Iterate the LinkedList
    public void iterate() {

        if (size == 0) {
            System.out.println("List is empty");
            return;
        }

        System.out.println("LinkedList Iteration ----");
        Iterator<Node> iterator = iterator();

        while(iterator.hasNext())
            System.out.print(" " +iterator.next().data);
    }

    @Override
    public Iterator<Node> iterator() {

        Iterator<Node> iterator = new Iterator<Node>() {

            Node currentIndex = head;
            Node prevIndex = null;

            @Override
            public boolean hasNext() {

                return currentIndex!=null;
            }

            @Override
            public Node next() {

                if(hasNext()) {
                    prevIndex = currentIndex;
                    currentIndex = currentIndex.next;
                    return prevIndex;
                }
                return null;
            }
        };
        return iterator;
    }
}