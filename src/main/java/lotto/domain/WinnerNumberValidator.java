package lotto.domain;

import java.util.List;
import lotto.constants.message.ExceptionMessage;

public class WinnerNumberValidator {
    public static final String LOTTO_NUMBER_CHECK = "^([0-9]*,){5}[0-9]*$";
    public static final String BONUS_NUMBER_CHECK = "^[0-9]*$";

    public static final String COMMA = ",";
    public static final int MAX_NUMBER = 6;
    public static final int MAXIMUM_NUMBER = 45;
    public static final int MINIMUM_NUMBER = 1;

    public void validateLottoNumber(String inputLottoNumber) {
        if (!inputLottoNumber.matches(LOTTO_NUMBER_CHECK)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.WINNING_FORMAT_ERROR);
        }
        if (isDuplicatedNumber(List.of(inputLottoNumber.split(COMMA)))) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.DUPLICATED_NUMBER);
        }
        if (isOutOfBounds(List.of(inputLottoNumber.split(COMMA)))) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.OUT_OF_BOUNDS);
        }
    }

    private boolean isOutOfBounds(List<String> splitInputWinningNumber) {
        return getMaximumNumber(splitInputWinningNumber) > MAXIMUM_NUMBER
                || getMinimumNumber(splitInputWinningNumber) < MINIMUM_NUMBER;
    }

    private int getMinimumNumber(List<String> splitInputWinningNumber) {
        return splitInputWinningNumber.stream()
                .map(Integer::parseInt)
                .min(Integer::compareTo)
                .get();
    }

    private int getMaximumNumber(List<String> splitInputWinningNumber) {
        return splitInputWinningNumber.stream()
                .map(Integer::parseInt)
                .max(Integer::compareTo)
                .get();
    }

    private boolean isDuplicatedNumber(List<String> splitInputWinningNumber) {
        return splitInputWinningNumber.stream()
                .distinct()
                .count() != MAX_NUMBER;
    }

    public void validateBonusNumber(String bonusNumber, List<Integer> numbers) {
        if (!bonusNumber.matches(BONUS_NUMBER_CHECK)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.NON_NUMERIC_INPUT);
        }
        if (Integer.parseInt(bonusNumber) < MINIMUM_NUMBER || Integer.parseInt(bonusNumber) > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.OUT_OF_BOUNDS);
        }
        if (numbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.DUPLICATED_NUMBER);
        }
    }
}
