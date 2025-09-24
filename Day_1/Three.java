package Day_1;

import java.util.Stack;

public class Three {
    public static void main(String[] args) {
        System.out.println("1 " + ValidParenthesis("()[]"));
        System.out.println("2 " + ValidParenthesis("()["));
        System.out.println("3 " + ValidParenthesis("(["));
        System.out.println("4 " + ValidParenthesis(""));
        System.out.println("5 " + ValidParenthesis("(]"));
    }

    public static boolean ValidParenthesis(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            Character chr = str.charAt(i);
            if (stack.size() == 0) {
                stack.push(str.charAt(i));
                continue;
            }

            if (chr == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(chr);
                }
            } else if (chr == ']') {

                if (stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(chr);
                }

            } else if (chr == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(chr);
                }
            } else {
                stack.push(chr);
            }

        }
        boolean res = false;
        if (stack.size() > 0) {
            res = false;
        } else {
            res = true;
        }
        return res;
    }
}
