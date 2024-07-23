
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(search(str));
    }

    private static String search(String str) {
        Stack<Character> stack = new Stack<>();
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                    result += stack.pop();
                }
            } else if (c == '+' || c == '-') {
                    while (!stack.isEmpty()) {
                        if (stack.peek() == '(') break;
                        result += stack.pop();
                }
//                     || stack.peek() == '*' || stack.peek() == '/'
                stack.push(c);
            } else if (c == '*' || c == '/') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(' || stack.peek() == '+' || stack.peek() == '-') break;
                    result += stack.pop();
                }
                stack.push(c);
            } else {
                result += c;
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
/*
A*(B*C+D)
A BC*D+ *
*(*+)

A+B*C/(D*E-F)+G
정답: ABC*DE*F-/+G+

A+B+C
정답: AB+C+

A*B*C
정답: AB*C*

G*(A-B*(C/D+E)/F)
정답: GABCD/E+*F/-*
*/