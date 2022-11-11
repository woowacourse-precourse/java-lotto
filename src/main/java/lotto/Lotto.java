package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_GAME_NUMBERS_SIZE = 6;
    private static final int LOTTO_GAME_START_NUMBER = 1;
    private static final int LOTTO_GAME_END_NUMBER = 45;
    private static final String COMMA = ",";
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
        if (!isSixNumbers(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_WRONG_NUMBER_OF_VALUE.getMessage());
        } else if (!isBetweenLottoRange(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_OUT_OF_RANGE.getMessage());
        }

    }

    private void validateString(String numbers) {
        if (isStringEmpty(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_WRONG_NUMBER_OF_VALUE.getMessage());
        } else if (!isDigit(convertStringToList(numbers))) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_OUT_OF_RANGE.getMessage());
        }

        validate(convertStringListToIntegerList(convertStringToList(numbers)));
    }

    private boolean isStringEmpty(String numbers) {
        return numbers == null || numbers.isBlank();
    }

    private boolean isDigit(List<String> numbers) {
        return numbers.stream().allMatch(number -> number.chars().allMatch(Character::isDigit));
    }

    private List<String> convertStringToList(String numbers) {
        return List.of(numbers.split(COMMA));
    }

    private List<Integer> convertStringListToIntegerList(List<String> numbers) {
        return  numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private boolean isSixNumbers(List<Integer> numbers) {
        return numbers.size() == LOTTO_GAME_NUMBERS_SIZE;
    }

    private boolean isBetweenLottoRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= LOTTO_GAME_START_NUMBER && number <= LOTTO_GAME_END_NUMBER);
    }
}
