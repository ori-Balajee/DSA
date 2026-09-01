import java.util.*;

public class infix2 {

    static int precedence(char ch) {
        if (ch == '^') return 3;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '+' || ch == '-') return 1;
        return 0;
    }

    static String convert(String infix) {
        Stack<Character> st = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (char ch : infix.toCharArray()) {

            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }
            else if (ch == '(') {
                st.push(ch);
            }
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(')
                    postfix.append(st.pop());

                st.pop();
            }
            else {
                while (!st.isEmpty() &&
                       precedence(st.peek()) >= precedence(ch)) {
                    postfix.append(st.pop());
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty())
            postfix.append(st.pop());

        return postfix.toString();
    }

    public static void main(String[] args) {
        String infix = "A+B*C";

        System.out.println(convert(infix));
    }
}