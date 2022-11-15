package lotto.validator;

import lotto.constant.Constant;
import lotto.constant.ErrorMessage;
import lotto.domain.Lotto;
import java.util.Arrays;
import java.util.List;
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

    public static void validateBonusNumber(Lotto lotto, String userInput) {
        int userInputNumber = Integer.parseInt(userInput);
        validateBonusNumberRange(userInputNumber);
        validateWinningNumberContainBonusNumber(lotto, userInputNumber);
    }

    public static void validateBonusNumberRange(int userInputNumber) {
        if (userInputNumber < Constant.MIN_LOTTO_NUMBER || userInputNumber > Constant.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_WRONG_RANGE);
        }
    }

    public static void validateWinningNumberContainBonusNumber(Lotto lotto, int userInputNumber) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        if (lottoNumbers.contains(userInputNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE);
        }
    }
}
