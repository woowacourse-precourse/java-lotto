package lotto.validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidateLotto {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final int LOTTO_NUMBER_SIZE = 6;


    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static void validateDuplicate(List<Integer> numbers) {
        Set<Integer> items = new HashSet<>();
        numbers.stream()
                .filter(n -> !items.add(n))
                .collect(Collectors.toSet());
        if (items.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
