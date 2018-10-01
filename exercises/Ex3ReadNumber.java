package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *   Extract numbers form Strings
 *
 *   See:
 *  - UseCharacter
 *  - UseStringBuilder
 *  - UseAList
 *  - WhyInterface
 *  - Exceptions
 */
public class Ex3ReadNumber {

    public static void main(String[] args) {
        new Ex3ReadNumber().program();
    }

    void program() {
        List<String> numbers = new ArrayList<>();

        // Argument 0 is index to start looking for digits.
        // Return value is index directly after last read digit
        out.println(readNumber(numbers, "1", 0) == 1);
        // The number should be in the list numbers (method should add number to list)
        out.println(numbers.contains("1"));
        numbers.clear();

        out.println(readNumber(numbers, "123", 0) == 3);
        out.println(numbers.contains("123") && !numbers.contains("1"));
        numbers.clear();

        out.println(readNumber(numbers, "123abc", 0) == 3);
        out.println(numbers.contains("123"));
        numbers.clear();

        out.println(readNumber(numbers, "12345abc", 0) == 5);
        out.println(numbers.contains("12345"));
        numbers.clear();

        out.println(readNumber(numbers, "abc123abc", 3) == 6);
        out.println(numbers.contains("123"));
        numbers.clear();

        // Empty string is not accepted will throw exception
        try {
            out.println(readNumber(numbers, "", 0) == 0);
        } catch (IllegalArgumentException e) {
            out.println(e.getMessage());   // Should print "Expr length is 0" or similar
        }

    }

    // ----------- Methods-----------------------------------


    int readNumber(List<String> numbers, String s, int i) {
        int stop = 0;
        boolean before = true;
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == s.toCharArray().length) {
                break;
            } if (c >= i && Character.isDigit(c)) {
                stop++;
                numbers.add(Character.toString(c));
                before = false;
            } else if (c >= i){
                if (before == false){
                    break;
                } else{
                    while (before){
                        stop++;
                        break;
                    }
                }


            }
        }
        if (numbers.isEmpty()){
            throw new IllegalArgumentException("Expr length is 0");
        }
        for (String st : numbers){
            sb.append(st);
        }
        String numberString = sb.toString();
        numbers.clear();
        numbers.add(numberString);


        out.println(numbers);
        return stop;
    }
}
