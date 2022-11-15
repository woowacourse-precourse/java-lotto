package lotto.utils;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberConverter {
    public static String convertToString(List<Integer> numbers) {
        return numbers.stream().map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
