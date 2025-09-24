package Day_1;

import java.util.Stack;

public class Four {
    public static void main(String[] args) {
        System.out.println("solution : " + DecodeString("33[a]2[b3[c]]"));
    }

    public static String DecodeString(String str) {
        Stack<Integer> stackNumbers = new Stack<>();
        Stack<String> stackOthers = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch >= 49 && ch <= 57) {
            } else {
                System.out.println("---------- char NOT num : " + ch);
            }
            if (ch >= 49 && ch <= 57) { // char is a number
                Integer inCh = ch - 48;
                System.out.println("---------- char num : " + inCh);
                stackNumbers.push(inCh);
            } else if (ch == ']') {
                String strNew = "";
                while (!stackOthers.peek().equals("[")) {
                    String popped = stackOthers.pop();
                    System.out.println("popped: " + popped);
                    System.out.println("new peek :" + stackOthers.peek() + ":");
                    strNew = strNew + popped;
                }
                stackOthers.pop();
                int num = stackNumbers.pop();
                System.out.println("strnew : " + strNew + " num : " + num);
                String strTemp = "";
                for (int j = 0; j < num; j++) {
                    strTemp = strTemp + strNew;
                }
                stackOthers.push(strTemp);
                System.out.println("top: " + stackOthers.peek());
            } else {
                System.out.println("pushed: " + ch);
                stackOthers.push("" + ch);
            }
        }

        String res = "";
        while (stackOthers.size() > 0) {
            res = res + stackOthers.pop();
        }

        res = stringReverse(res);
        return res;

    }

    public static String stringReverse(String str) {
        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            st.push(str.charAt(i));
        }
        String res = "";

        while (st.size() > 0) {
            res = res + st.pop();
        }
        return res;
    }
}
