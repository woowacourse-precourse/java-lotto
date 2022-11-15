package lotto;

import java.util.Arrays;

public class Validate {
    public boolean wrongNumber(int number) {
        return (number <= 0 || number >= 46);
    }

    public boolean duplicateNumber(int number, int[] numbers) {
        return Arrays.stream(numbers).anyMatch(n -> n == number);
    }
}
