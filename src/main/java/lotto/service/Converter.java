package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Converter {

    public static List<Integer> convertStringToNumbers(String numbers) {
        return Stream.of(numbers.split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }
}