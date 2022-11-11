package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final static String COMMA = ",";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers) {
        validateString(numbers);
        this.numbers = new ArrayList<>();
    }

    private void validate(List<Integer> numbers) {

    }

    private void validateString(String numbers) {
        if (isStringEmpty(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_WRONG_NUMBER_OF_VALUE.getMessage());
        } else if (!isDigit(convertStringToList(numbers))) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isStringEmpty(String numbers) {
        return numbers == null || numbers.isBlank();
    }

    private List<String> convertStringToList(String numbers) {
        return List.of(numbers.split(COMMA));
    }

    private boolean isDigit(List<String> numbers) {
        return numbers.stream().allMatch(number -> number.chars().allMatch(Character::isDigit));
    }
}
