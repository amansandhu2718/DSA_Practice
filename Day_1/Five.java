package Day_1;

import java.util.Stack;

public class Five {
    public static void main(String[] args) {
        NextGreaterElement();
    }

    public static void NextGreaterElement() {
        Stack<Integer> stack = new Stack<>();
        int arr[] = new int[] { 1, 3, 2, 4 };

        stack.push(arr[arr.length - 1]);
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            while (stack.size() > 0 && stack.peek() <= arr[i]) {
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
