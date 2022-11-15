package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static int NUMBERS_COUNT = 6;
    public static int PRICE = 1000;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new).collect(Collectors.toList());
    }

    private static void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplication(numbers);
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_COUNT) {
            throw new IllegalArgumentException(
                    InvalidInputMessage.ERR_DEFAULT
                            + InvalidInputMessage.ERR_NUMBERS_COUNT
            );
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        Set<Integer> set = new HashSet<Integer>(numbers);
        if (set.size() != NUMBERS_COUNT) {
            throw new IllegalArgumentException(
                    InvalidInputMessage.ERR_DEFAULT
                            + InvalidInputMessage.ERR_DUPLICATED_NUMBER
            );
        }
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
