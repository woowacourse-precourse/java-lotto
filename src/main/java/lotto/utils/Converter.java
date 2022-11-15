package lotto.utils;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static Lotto toLotto(String inputNumbers) {
        return new Lotto(of(inputNumbers));
    }

    private static List<Integer> of(String inputNumbers) {
        List<String> numbers = Arrays.asList(inputNumbers.split(","));
        return numbers.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
