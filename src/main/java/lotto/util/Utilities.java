package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

public class Utilities {
    public static List<Integer> sort(List<Integer> numbers) {
        return numbers
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
