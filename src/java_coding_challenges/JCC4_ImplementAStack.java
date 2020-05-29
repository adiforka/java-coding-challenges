package java_coding_challenges;

public class JCC4_ImplementAStack {
    public static void main(String[] args) {

        Stack<String> stringStack = new Stack<>(5);
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.push("How");
        stringStack.push("U");
        stringStack.push("Doing?");

        System.out.println("Stack is full? : " + stringStack.isFull());

        System.out.println("popped: " + stringStack.pop());
        System.out.println("popped: " + stringStack.pop());
        System.out.println("popped: " + stringStack.pop());
        System.out.println("popped: " + stringStack.pop());
        System.out.println("popped: " + stringStack.pop());

        System.out.println("Stack is empty? : " + stringStack.isEmpty());

        stringStack.push("Something here");
        System.out.println("peek top element: " + stringStack.peek());

        Stack<Integer> numberStack = new Stack<>(10);
        numberStack.push(78);
        numberStack.push(66);
        numberStack.push(43);
        System.out.println("peek top element: " + numberStack.peek());
        numberStack.push(666);
        numberStack.push(666);
        numberStack.push(666);
        numberStack.push(666);
        numberStack.push(666);
        numberStack.push(666);
        numberStack.push(666);
        System.out.println("peek top element: " + numberStack.peek());
        System.out.println("Stack is full? : " + numberStack.isFull());

    }
}

class Stack<E> {
    private int capacity;
    private int top;
    private E[] array;

    public Stack(int initialCapacity) {
        array = (E[]) new Object[initialCapacity];
        capacity = initialCapacity;
        top = -1;
    }

    //essential
    public void push(E element) {
        if(isFull()) {
            throw new RuntimeException("Stack is empty");
        }
        array[++top] = element;
    }

    //essential (modifies the stack)
    public E pop() {
        if(isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        E element = array[top];
        //don't really need to clear out the element from here
        array[top--] = null;
        return element;

    }

    //essential (does not modify the stack)
    public E peek() {
        if(isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return array[top];
    }

    //for good measure
    public boolean isFull() {
        //at first element, top == 0, at element at capacity, top == capacity - 1;
        return top == capacity - 1;
    }

    //for good measure
    public boolean isEmpty() {
        return top == -1;
    }
}
