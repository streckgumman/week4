package exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *
 *  Use a Stack to check parentheses (balanced and correct nesting)
 *  The parentheses are: (), [] and {}
 *
 *  See:
 *  - UseAStack
 *  - WhyInterface
 *  - SwitchStatement
 *
 */
public class Ex4CheckParen {

    public static void main(String[] args) {
        new Ex4CheckParen().program();
    }

    void program() {
        // All should be true
        out.println(checkParentheses("()"));
        out.println(checkParentheses("(()())"));
        out.println(!checkParentheses("(()))")); // Unbalanced
        out.println(!checkParentheses("((())")); // Unbalanced

        out.println(checkParentheses("({})"));
        out.println(!checkParentheses("({)}"));  // Bad nesting
        out.println(checkParentheses("({} [()] ({}))"));
        out.println(!checkParentheses("({} [() ({)})"));  // Unbalanced and bad nesting
    }

    boolean checkParentheses(String expr) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : expr.toCharArray()) {
            if (isOpeningParen(ch)) {
                stack.push(ch);
            } else if (isClosingParen(ch)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char t = stack.peek();
                if (matching(ch) == t) {
                    stack.pop();
                } else {
                    return false;
                }
            } else{
                //skip any other char
            }
        }
        return stack.isEmpty();
    }

    boolean isOpeningParen(char ch) {
        return "({[".indexOf(ch) >= 0;
    }

    boolean isClosingParen(char ch) {
        return ")}]".indexOf(ch) >= 0;
    }


    // This is interesting because have to return, but what if no match?!?
    char matching(char ch) {
        //char c =  must initialize but to what?!
        switch (ch) {
            case ')':
                return '(';  // c = '('
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                // return c;
                throw new IllegalArgumentException("No match found");
        }
    }
}
