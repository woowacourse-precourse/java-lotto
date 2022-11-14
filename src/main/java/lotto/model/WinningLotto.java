package lotto.model;

import static lotto.constant.LottoConstants.LOTTO_SIZE;
import static lotto.constant.LottoConstants.MAX_VALID_LOTTO_VALUE;
import static lotto.constant.LottoConstants.MIN_VALID_LOTTO_VALUE;
import static lotto.constant.WinningLottoConstants.DUPLICATE_WINNING_NUMBER_EXIST_MSG;
import static lotto.constant.WinningLottoConstants.INVALID_RANGED_WINNING_LOTTO_INPUT_MSG;
import static lotto.constant.WinningLottoConstants.INVALID_WINNING_LOTTO_INPUT_FORM_MSG;
import static lotto.constant.WinningLottoConstants.INVALID_WINNING_LOTTO_SIZE_MSG;
import static lotto.constant.WinningLottoConstants.SLICE_DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private Lotto lotto;

    public static WinningLotto from(String userInput) {
        return new WinningLotto(userInput);
    }

    private WinningLotto(String userInput) {
        validate(userInput);
        this.lotto = new Lotto(toList(userInput));
    }

    public Lotto getLotto() {
        return this.lotto;
    }

    private void validate(String userInput) {
        isBlank(userInput);
        validateSlicedUserInput(userInput);
    }

    private void isBlank(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(INVALID_WINNING_LOTTO_SIZE_MSG);
        }
    }

    private void validateSlicedUserInput(String userInput) {
        final String[] slicedUserInput = userInput.split(SLICE_DELIMITER);

        isValidInputForm(slicedUserInput);
        isConsistWithProperRange(slicedUserInput);
        hasDuplicateNumber(slicedUserInput);
    }

    private void isValidInputForm(String[] slicedUserInput) {
        if (slicedUserInput.length != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_WINNING_LOTTO_INPUT_FORM_MSG);
        }
    }

    private void isConsistWithProperRange(String[] slicedUserInput) {
        for (String piece : slicedUserInput) {
            isInRange(piece);
        }
    }

    private void isInRange(String piece) {
        isNumeric(piece);
        int pieceToInt = isIntegerRange((piece));
        if (pieceToInt < MIN_VALID_LOTTO_VALUE || pieceToInt > MAX_VALID_LOTTO_VALUE) {
            throw new IllegalArgumentException(INVALID_RANGED_WINNING_LOTTO_INPUT_MSG);
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
            throw new IllegalArgumentException(INVALID_RANGED_WINNING_LOTTO_INPUT_MSG);
        }
    }

    private int isIntegerRange(String piece) {
        try {
            int pieceToInt = Integer.parseInt(piece);
            return pieceToInt;
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_RANGED_WINNING_LOTTO_INPUT_MSG);
        }
    }

    private void hasDuplicateNumber(String[] slicedUserInput) {
        if (Arrays.stream(slicedUserInput)
                .distinct()
                .count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER_EXIST_MSG);
        }
    }

    private List<Integer> toList(String userInput) {
        return Arrays.stream(userInput.split(SLICE_DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
