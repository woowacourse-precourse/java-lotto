package lotto.validator;

import lotto.constant.Constant;
import lotto.constant.ErrorMessage;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningLottoValidator {
    public static void validateWinningNumber(String userInput) {
        try {
            Arrays.stream(userInput.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_WRONG_TYPE);
        }
    }

    public static void validateBonusNumberRange(int userInputNumber) {
        if (userInputNumber < Constant.MIN_LOTTO_NUMBER || userInputNumber > Constant.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_WRONG_RANGE);
        }
    }
}
