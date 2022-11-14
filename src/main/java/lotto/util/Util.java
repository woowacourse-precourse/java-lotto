package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.constance.InputExceptionConstance.COMMA;

public class Util {
    private static int[] toIntArray(String inputNumbers) {
        return Stream.of(inputNumbers.split(COMMA)).mapToInt(Integer::parseInt).toArray();
    }

    public static List<Integer> toList(String inputNumbers) {
        int[] numbers = toIntArray(inputNumbers);
        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());
    }

    public static String toStringOfList(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();
        numbers.forEach(sb::append);
        return sb.toString();
    }

    private Util() {
    }
}
