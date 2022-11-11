package lotto.model;

import static lotto.constant.LottoConstants.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String userInput) {
        validate(userInput);
        List<Integer> numbers = Arrays.stream(userInput.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        validate(numbers);
        this.numbers=numbers;
    }

    private void validate(List<Integer> numbers) {
        isValidSize(numbers);
        hasDuplicateNumber(numbers);
    }

    private void validate(String userInput) {
        isBlank(userInput);
        canSplit(userInput);
    }

    private void isValidSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_MSG);
        }
    }

    private void hasDuplicateNumber(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXIST_MSG);
        }
    }

    private void isBlank(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(EMPTY_LOTTO_VALUE_MSG);
        }
    }

    private void canSplit(String userInput) {
        if (userInput.split(",").length != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_INPUT_FORM);
        }
    }

}
