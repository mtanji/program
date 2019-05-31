package logic;

import java.util.stream.IntStream;

/**
 * https://www.codewars.com/kata/sum-of-positive
 */
public class SumOfPositive {

    public static void main(String[] args) {

        SumOfPositiveTest sop = new SumOfPositiveTest();
        sop.givenArrayIsNullWhenSolveThenReturnZero();
        sop.givenArrayIsEmptyWhenSolveThenReturnZero();
        sop.givenArrayHasOneIntegerWhenSolveThenReturnSameValue();
        sop.givenArrayHasOneNegativeIntegerWhenSolveThenReturnZero();
        sop.givenArrayHasMultipleIntegersWhenSolveThenReturnSameValue();
        sop.givenArrayHasMultipleNegativeIntegersWhenSolveThenReturnZero();
        sop.givenArrayHasMultipleMixedIntegersWhenSolveThenReturnSumOfPositiveValues();

        System.out.print("Finished without errors");
    }

    int solve(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        return IntStream.of(input).filter(n -> n > 0).sum();
    }
}

class SumOfPositiveTest {

    void givenArrayIsNullWhenSolveThenReturnZero() {
        int[] input = null;
        int expectedOutput = 0;
        SumOfPositive sop = new SumOfPositive();
        int result = sop.solve(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }

    void givenArrayIsEmptyWhenSolveThenReturnZero() {
        int[] input = new int[]{};
        int expectedOutput = 0;
        SumOfPositive sop = new SumOfPositive();
        int result = sop.solve(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }

    void givenArrayHasOneIntegerWhenSolveThenReturnSameValue() {
        int[] input = new int[]{10};
        int expectedOutput = 10;
        SumOfPositive sop = new SumOfPositive();
        int result = sop.solve(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }

    void givenArrayHasMultipleIntegersWhenSolveThenReturnSameValue() {
        int[] input = new int[]{10, 15};
        int expectedOutput = 25;
        SumOfPositive sop = new SumOfPositive();
        int result = sop.solve(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }

    void givenArrayHasOneNegativeIntegerWhenSolveThenReturnZero() {
        int[] input = new int[]{-10};
        int expectedOutput = 0;
        SumOfPositive sop = new SumOfPositive();
        int result = sop.solve(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }

    void givenArrayHasMultipleNegativeIntegersWhenSolveThenReturnZero() {
        int[] input = new int[]{-10, -1, -8};
        int expectedOutput = 0;
        SumOfPositive sop = new SumOfPositive();
        int result = sop.solve(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }

    void givenArrayHasMultipleMixedIntegersWhenSolveThenReturnSumOfPositiveValues() {
        int[] input = new int[]{1, -4, 7, 12};
        int expectedOutput = 20;
        SumOfPositive sop = new SumOfPositive();
        int result = sop.solve(input);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }

}