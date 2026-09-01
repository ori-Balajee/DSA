import java.util.*;

public class infix {
    public static void main(String[] args) {
        System.out.println("Hellp");

        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.pop();
        System.out.println(st.peek());

        String infix = "A+B*C";
        System.out.println(infix2.convert(infix));
    }
}