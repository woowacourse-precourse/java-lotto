package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transform {
    public static List<String> splitedNumbers(String input) {
        String[] splitedInput = Arrays.stream(input.split(","))
                .map(String::trim)
                .toArray(String[]::new);
        List<String> numbers = new ArrayList<>(List.of(splitedInput));
        return numbers;
    }

    public static List<Integer> convertType(List<String> input) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : input) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
