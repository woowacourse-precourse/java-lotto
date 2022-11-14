package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {

    public static int LOTTO_MAX_NUMBER = 45;
    public static int LOTTO_MIN_NUMBER = 1;

    public static int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private static void validate(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateDuplication(numbers);
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    InvalidInputMessage.ERR_DEFAULT
                            + InvalidInputMessage.ERR_NUMBERS_COUNT
            );
        }
    }

    private static void validateNumberRange(int number) {
        if (LOTTO_MIN_NUMBER <= number
                && number <= LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(
                    InvalidInputMessage.ERR_DEFAULT
                            + InvalidInputMessage.ERR_NUMBER_RANGE
            );
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        while (!numbers.isEmpty()) {
            int number = numbers.get(0);
            if (numbers.contains(number)) {
                throw new IllegalArgumentException(
                        InvalidInputMessage.ERR_DEFAULT
                                + InvalidInputMessage.ERR_DUPLICATED_NUMBER
                );
            }
        }
    }

    public List<Integer> getNumbers(){
        return Collections.unmodifiableList(numbers);
    }
}
