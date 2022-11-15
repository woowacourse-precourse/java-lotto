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
}
