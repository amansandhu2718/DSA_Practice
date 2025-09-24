package Day_1;

import java.util.Stack;

public class Nine {
    public static boolean debug = true; // flag for testing

    public static void main(String[] args) {
        int arr[] = new int[] { 2, 1, 5, 6, 2, 3 };
        System.out.println("final Ans : " + largestRectangleArea(arr));
    }

    public static int largestRectangleArea(int arr[]) {

        Node arrRes[] = new Node[arr.length];
        // initialize each Node object
        for (int i = 0; i < arr.length; i++) {
            arrRes[i] = new Node();
        }
        // populating NodeArray
        NextSmallerElement(arr, arrRes);
        if (debug) {
            System.out.println("---------------------");
        }
        PreviousSmallerElement(arr, arrRes);
        if (debug) {
            System.out.println("---------------------");
        }
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = arrRes[i].previousSmaller + 1;
            int right = arrRes[i].nextSmaller - 1;
            int width = right - left + 1;
            int area = arr[i] * width;
            maxArea = Math.max(maxArea, area);
            if (debug) {
                System.out.println("Bar " + arr[i] +
                        " | left=" + left +
                        " | right=" + right +
                        " | width=" + width +
                        " | area=" + area);
            }
        }

        return maxArea;
    }

    public static void NextSmallerElement(int arr[], Node[] arrResIndex) {
        Stack<Integer> stackOfIndex = new Stack<>();

        stackOfIndex.push(arr.length - 1); // push index for next ith element
        arrResIndex[arr.length - 1].nextSmaller = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {
            while (!stackOfIndex.isEmpty() && arr[stackOfIndex.peek()] > arr[i]) {
                stackOfIndex.pop();
            }

            if (stackOfIndex.isEmpty()) {
                arrResIndex[i].nextSmaller = arr.length;
            } else {
                int peekIdx = stackOfIndex.peek(); // index of next smaller
                arrResIndex[i].nextSmaller = peekIdx;
            }

            stackOfIndex.push(i); // ✅ push index, not value
        }

        if (debug) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println("arr[" + i + "] = " + arr[i] +
                        " | nextSmaller index = " + arrResIndex[i].nextSmaller +
                        (arrResIndex[i].nextSmaller < arr.length ? " (val=" + arr[arrResIndex[i].nextSmaller] + ")"
                                : " (none)"));
            }
        }
    }

    public static void PreviousSmallerElement(int arr[], Node[] arrResIndex) {
        Stack<Integer> stackOfIndex = new Stack<>();

        stackOfIndex.push(0); // first element
        arrResIndex[0].previousSmaller = -1; // no left element

        for (int i = 1; i < arr.length; i++) {
            while (!stackOfIndex.isEmpty() && arr[stackOfIndex.peek()] >= arr[i]) {
                stackOfIndex.pop();
            }

            if (stackOfIndex.isEmpty()) {
                arrResIndex[i].previousSmaller = -1; // none
            } else {
                int peekIdx = stackOfIndex.peek(); // index of prev smaller
                arrResIndex[i].previousSmaller = peekIdx;
            }

            stackOfIndex.push(i); // push current index
        }

        if (debug) {
            // Print result
            for (int i = 0; i < arr.length; i++) {
                System.out.println("arr[" + i + "] = " + arr[i] +
                        " | prevSmaller index = " + arrResIndex[i].previousSmaller +
                        (arrResIndex[i].previousSmaller >= 0
                                ? " (val=" + arr[arrResIndex[i].previousSmaller] + ")"
                                : " (none)"));
            }
        }
    }
}

class Node {
    int previousSmaller;
    int nextSmaller;
}