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

        hasDuplicateNumber(numbers);
        this.numbers=numbers;
    }

    private void validate(List<Integer> numbers) {
        isValidSize(numbers);
        hasDuplicateNumber(numbers);
    }

    private void validate(String userInput) {
        isBlank(userInput);
        canSplit(userInput);
        isConsistWithProperRange(userInput);
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

    private void isConsistWithProperRange(String userInput){
        for (String piece : userInput.split(",")) {
            isInRange(piece);
        }
    }

    private void isInRange(String piece) {
        isNumeric(piece);
        int pieceToInt = Integer.parseInt(piece);
        if (pieceToInt < MIN_VALID_LOTTO_VALUE || pieceToInt >MAX_VALID_LOTTO_VALUE ) {
            throw new IllegalArgumentException(INVALID_RANGED_LOTTO_INPUT);
        }
    }

    private void isNumeric(String piece) {
        isBlank(piece);
        for (char characterInPiece : piece.toCharArray()) {
            isDigit(characterInPiece);
        }
    }

    private void isDigit(char characterInPiece) {
        if (!Character.isDigit(characterInPiece)) {
            throw new IllegalArgumentException(INVALID_RANGED_LOTTO_INPUT);
        }
    }


}
