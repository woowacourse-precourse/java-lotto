package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final Integer MAX_SIZE = 6;
    public static final Integer START_NUMBER = 1;
    public static final Integer END_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> newNumbers = new ArrayList<>(numbers);
        validate(newNumbers);
        Collections.sort(newNumbers);
        this.numbers = newNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isValidateLength(numbers)) {
            String message = Error.getErrorMessage(Error.Messages.LOTTO_NUMBER_LENGTH_ERROR);
            throw new IllegalArgumentException(message);
        }
        if (!isValidateRange(numbers)) {
            String message = Error.getErrorMessage(Error.Messages.LOTTO_NUMBER_RANGE_ERROR);
            throw new IllegalArgumentException(message);
        }
        if (!isValidateUnique(numbers)) {
            String message = Error.getErrorMessage(Error.Messages.LOTTO_NUMBER_UNIQUE_ERROR);
            throw new IllegalArgumentException(message);
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public static boolean isValidateUnique(List<Integer> numbers) {
        return numbers.stream().distinct().count() == MAX_SIZE;
    }

    public static boolean isValidateLength(List<Integer> numbers) {
        return numbers.size() == MAX_SIZE;
    }

    public static boolean isValidateRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(Lotto::isValidateRange);
    }

    public static boolean isValidateRange(Integer number) {
        return number >= START_NUMBER && number <= END_NUMBER;
    }

}
