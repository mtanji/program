package logic;

import java.util.stream.IntStream;

public class ArrayRemovedElement {

    public static void main(String[] args) {
        ArrayRemovedElementTest are = new ArrayRemovedElementTest();
        are.givenNullOrWrongLengthWhenFindReturnMinusOne();
        are.givenMissing13WhenFindReturn13();
        are.givenMissing0WhenFindReturn0();
        are.givenMissing99WhenFindReturn99();

        System.out.print("Finished without errors");
    }

    int removedValue(int[] original, int[] missingElement) {
        if (original == null || original.length != 100 || missingElement == null || missingElement.length != 100) {
            return -1;
        }
        int originalSum = IntStream.of(original).sum();
        int missingElementSum = IntStream.of(missingElement).sum();
        return originalSum - missingElementSum;
    }
}

class ArrayRemovedElementTest {

    int[] fullArray;

    private void setup() {
        fullArray = new int[100];
        for (int i = 0; i < 100; i++) {
            fullArray[i] = i;
        }
    }

    void givenNullOrWrongLengthWhenFindReturnMinusOne() {
        setup();
        int[] original = null;
        int[] missingElement = fullArray;
        int expectedOutput = -1;
        ArrayRemovedElement are = new ArrayRemovedElement();
        int result = are.removedValue(original, missingElement);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }

        original = new int[99];
        missingElement = fullArray;
        expectedOutput = -1;
        are = new ArrayRemovedElement();
        result = are.removedValue(original, missingElement);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }

        original = fullArray;
        missingElement = null;
        expectedOutput = -1;
        are = new ArrayRemovedElement();
        result = are.removedValue(original, missingElement);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }

        original = fullArray;
        missingElement = new int[99];
        expectedOutput = -1;
        are = new ArrayRemovedElement();
        result = are.removedValue(original, missingElement);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }

    void givenMissing13WhenFindReturn13() {
        setup();
        int[] original = fullArray;
        int[] missingElement = fullArray.clone();
        missingElement[13] = 0;
        int expectedOutput = 13;
        ArrayRemovedElement are = new ArrayRemovedElement();
        int result = are.removedValue(original, missingElement);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }

    void givenMissing0WhenFindReturn0() {
        setup();
        int[] original = fullArray;
        int[] missingElement = fullArray.clone();
        missingElement[0] = 0;
        int expectedOutput = 0;
        ArrayRemovedElement are = new ArrayRemovedElement();
        int result = are.removedValue(original, missingElement);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }

    void givenMissing99WhenFindReturn99() {
        setup();
        int[] original = fullArray;
        int[] missingElement = fullArray.clone();
        missingElement[13] = 0;
        int expectedOutput = 13;
        ArrayRemovedElement are = new ArrayRemovedElement();
        int result = are.removedValue(original, missingElement);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }
}