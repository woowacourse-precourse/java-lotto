package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convertor {

    public static List<Integer> convertStringListToInterList(List<String> numbers) {
        return numbers.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<String> convertStringToList(String number, String standard) {
        return Arrays.stream(number.split(standard))
                .collect(Collectors.toList());
    }
}
