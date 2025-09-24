package Day_1;

import java.util.Stack;

public class Ten {
    public static boolean debug = true;

    public static void main(String[] args) {
        int arr[] = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };
        int arrRes[] = NextGreaterElement(arr);
        int answer[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arrRes[i] < arr.length) {
                answer[i] = arrRes[i] - i; // days to wait
            } else {
                answer[i] = 0; // no warmer day
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.err.println(answer[i]);
        }
    }

    public static int[] NextGreaterElement(int arr[]) {
        Stack<Integer> stackOfIndex = new Stack<>();
        int arrRes[] = new int[arr.length];

        stackOfIndex.push(arr.length - 1); // last element
        arrRes[arr.length - 1] = arr.length; // no greater to right

        for (int i = arr.length - 2; i >= 0; i--) {
            while (!stackOfIndex.isEmpty() && arr[stackOfIndex.peek()] <= arr[i]) {
                stackOfIndex.pop();
            }

            if (stackOfIndex.isEmpty()) {
                arrRes[i] = arr.length;
            } else {
                int peekIdx = stackOfIndex.peek(); // index of next greater
                arrRes[i] = peekIdx;
            }

            stackOfIndex.push(i);
        }

        if (debug) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println("arr[" + i + "] = " + arr[i] +
                        " | nextGreater index = " + arrRes[i] +
                        (arrRes[i] < arr.length
                                ? " (val=" + arr[arrRes[i]] + ")"
                                : " (none)"));
            }
        }
        return arrRes;
    }

}
