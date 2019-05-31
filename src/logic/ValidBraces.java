package logic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * https://www.codewars.com/kata/valid-braces/elixir
 */
public class ValidBraces {

    Map<String, String> closeToOpen = new HashMap<>(Map.of(")", "(", "]", "[", "}", "{"));
    Set<String> openingSymbols = new HashSet<>(Arrays.asList("(", "[", "{"));

    public static void main(String[] args) {
        ValidBracesTest vb = new ValidBracesTest();
        vb.givenJustOpensWhenValidateThenReturnFalse();
        vb.givenJustClosesWhenValidateThenReturnFalse();
        vb.givenInvalidPairsWhenValidateThenReturnFalse();
        vb.givenValidPairsWhenValidateThenReturnTrue();
        vb.givenValidNestedPairsWhenValidateThenReturnTrue();
        vb.givenInvalidNestedPairsWhenValidateThenReturnFalse();

        System.out.print("Finished without errors");
    }

    /**
     * When valid opening brace is read, push to stack. When valid closing brace is read, confirm if it forms a pair
     * with stack top symbol. If is a valid pair, pop symbol from stack.
     */
    boolean valid(String braces) {

        Stack<String> stack = new Stack<>();
        char[] chars = braces.toCharArray();
        for (char c : chars) {
            String currentSymbol = Character.toString(c);
            if (openingSymbols.contains(currentSymbol)) {
                stack.push(currentSymbol);
            } else {
                if (stack.empty()) {
                    return false;
                } else {
                    String top = stack.peek();
                    if (top.equals(closeToOpen.get(currentSymbol))) {
                        stack.pop();
                    }
                }
            }
        }

        return stack.empty();
    }
}

class ValidBracesTest {

    void givenJustOpensWhenValidateThenReturnFalse() {
        String input = "(";
        boolean expectedOutput = false;
        ValidBraces vb = new ValidBraces();
        boolean result = vb.valid(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }

        input = "[";
        expectedOutput = false;
        vb = new ValidBraces();
        result = vb.valid(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
        input = "{";
        expectedOutput = false;
        vb = new ValidBraces();
        result = vb.valid(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }

    void givenJustClosesWhenValidateThenReturnFalse() {
        String input = ")";
        boolean expectedOutput = false;
        ValidBraces vb = new ValidBraces();
        boolean result = vb.valid(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }

        input = "]";
        expectedOutput = false;
        vb = new ValidBraces();
        result = vb.valid(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
        input = "}";
        expectedOutput = false;
        vb = new ValidBraces();
        result = vb.valid(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }

    void givenInvalidPairsWhenValidateThenReturnFalse() {
        String input = "(}";
        boolean expectedOutput = false;
        ValidBraces vb = new ValidBraces();
        boolean result = vb.valid(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }

        input = "{]";
        expectedOutput = false;
        vb = new ValidBraces();
        result = vb.valid(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
        input = "[)";
        expectedOutput = false;
        vb = new ValidBraces();
        result = vb.valid(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }

    void givenValidPairsWhenValidateThenReturnTrue() {
        String input = "()[]{}";
        boolean expectedOutput = true;
        ValidBraces vb = new ValidBraces();
        boolean result = vb.valid(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }

    void givenValidNestedPairsWhenValidateThenReturnTrue() {
        String input = "([{}])";
        boolean expectedOutput = true;
        ValidBraces vb = new ValidBraces();
        boolean result = vb.valid(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }

    void givenInvalidNestedPairsWhenValidateThenReturnFalse() {
        String input = "[(])";
        boolean expectedOutput = false;
        ValidBraces vb = new ValidBraces();
        boolean result = vb.valid(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }

        input = "[({})](]";
        expectedOutput = false;
        vb = new ValidBraces();
        result = vb.valid(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }

}