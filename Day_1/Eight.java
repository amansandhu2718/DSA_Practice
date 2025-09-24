package Day_1;

import java.util.Stack;

public class Eight {
    public static void main(String[] args) {
        PreviousSmallerElement();
    }

    public static void PreviousSmallerElement() {
        Stack<Integer> stack = new Stack<>();
        int arr[] = new int[] { 5, 1, 3, 2, 4 };

        stack.push(arr[0]);
        arr[0] = -1;
        for (int i = 1; i < arr.length; i++) {

            while (stack.size() > 0 && stack.peek() > arr[i]) {

                stack.pop();
            }

            if (stack.size() == 0) {

                stack.push(arr[i]);
                arr[i] = -1;

            } else {
                int peekEle = stack.peek();
                stack.push(arr[i]);

                arr[i] = peekEle;
            }

        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr i : " + arr[i]);
        }
    }
}
