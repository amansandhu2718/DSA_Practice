package Day_1;

public class One {
    public static void main(String[] args) {
        // Stack of Integers
        CustomStack<Integer> intStack = new CustomStack<>();
        intStack.push(10);
        intStack.push(20);
        System.out.println("Peek: " + intStack.peek()); // 20
        System.out.println("Pop: " + intStack.pop()); // 20

        // Stack of Strings
        CustomStack<String> stringStack = new CustomStack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        System.out.println("Peek: " + stringStack.peek()); // World
        System.out.println("Pop: " + stringStack.pop()); // World
    }
}

class CustomStack<T> { // <T> makes it generic
    private java.util.ArrayList<T> list = new java.util.ArrayList<>();

    // push
    public void push(T value) {
        list.add(value);
        System.out.println("Pushed: " + value);
    }

    // pop
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return null;
        }
        return list.remove(list.size() - 1);
    }

    // peek
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return list.get(list.size() - 1);
    }

    // check empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // size
    public int size() {
        return list.size();
    }
}

// package Day_1;

// public class One {
// public static void main(String[] args) {
// // Stack of Integers
// CustomStack<Integer> intStack = new CustomStack<>(5);
// intStack.push(10);
// intStack.push(20);
// intStack.push(30);
// System.out.println("Peek: " + intStack.peek()); // 30
// System.out.println("Pop: " + intStack.pop()); // 30

// // Stack of Strings
// CustomStack<String> stringStack = new CustomStack<>(3);
// stringStack.push("Hello");
// stringStack.push("World");
// System.out.println("Peek: " + stringStack.peek()); // World
// System.out.println("Pop: " + stringStack.pop()); // World
// }
// }

// class CustomStack<T> {
// private Object[] arr; // array of Objects (can't create T[] directly in Java)
// private int top;
// private int capacity;

// public CustomStack(int size) {
// arr = new Object[size];
// capacity = size;
// top = -1;
// }

// // push
// public void push(T value) {
// if (top == capacity - 1) {
// System.out.println("Stack Overflow!");
// return;
// }
// arr[++top] = value;
// System.out.println("Pushed: " + value);
// }

// // pop
// @SuppressWarnings("unchecked")
// public T pop() {
// if (isEmpty()) {
// System.out.println("Stack Underflow!");
// return null;
// }
// return (T) arr[top--];
// }

// // peek
// @SuppressWarnings("unchecked")
// public T peek() {
// if (isEmpty()) {
// System.out.println("Stack is empty!");
// return null;
// }
// return (T) arr[top];
// }

// public boolean isEmpty() {
// return top == -1;
// }

// public int size() {
// return top + 1;
// }
// }
