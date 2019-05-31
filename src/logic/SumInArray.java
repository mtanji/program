package logic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class SumInArray {

    public static void main(String[] args) {

        SumInArrayTest sia = new SumInArrayTest();
        sia.givenNullArrayOrEmptyArrayWhenValidateThenReturnFalse();
        sia.givenMixedInputAndValidSumWhenValidateThenReturnTrue();
        sia.givenMixedInputAndInvalidSumWhenValidateThenReturnFalse();

        System.out.print("Finished without errors");
    }

    /**
     * Complexidade do algoritmo: O(n), onde n é o número de elementos do array. Pois, no pior caso, quando não existem
     * dois números no array que façam a soma pedida, deve-se percorrer todos os números para se chegar à conclusão que
     * tais números não existem.
     */
    boolean hasSumInArray(int[] array, int sum) {
        if (array == null || array.length < 2) {
            return false;
        }
        boolean found = false;
        Set<Integer> numbers = Arrays.stream(array).boxed().collect(Collectors.toSet());
        Iterator it = numbers.iterator();
        while (it.hasNext()) {
            int current = (Integer) it.next();
            found = numbers.contains(sum - current);
            if (found) {
                break;
            }
        }
        return found;
    }
}

class SumInArrayTest {

    void givenNullArrayOrEmptyArrayWhenValidateThenReturnFalse() {
        int[] array = null;
        int sum = 19;
        boolean expectedOutput = false;
        SumInArray sia = new SumInArray();
        boolean result = sia.hasSumInArray(array, sum);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }

        array = new int[]{};
        sum = 19;
        expectedOutput = false;
        sia = new SumInArray();
        result = sia.hasSumInArray(array, sum);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }

    void givenMixedInputAndValidSumWhenValidateThenReturnTrue() {
        int[] array = new int[]{4, 1, 22, 9, 10};
        int sum = 19;
        boolean expectedOutput = true;
        SumInArray sia = new SumInArray();
        boolean result = sia.hasSumInArray(array, sum);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }

    void givenMixedInputAndInvalidSumWhenValidateThenReturnFalse() {
        int[] array = new int[]{4, 1, 22, 9, 10};
        int sum = 6;
        boolean expectedOutput = false;
        SumInArray sia = new SumInArray();
        boolean result = sia.hasSumInArray(array, sum);
        if (result != expectedOutput) {
            throw new IllegalStateException();
        }
    }
}