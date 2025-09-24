package Day_1;

import java.util.Stack;

public class Two {
    public static void main(String[] args) {
        String rev = stringReverse("abcdefghi");
        System.out.println(rev);
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
