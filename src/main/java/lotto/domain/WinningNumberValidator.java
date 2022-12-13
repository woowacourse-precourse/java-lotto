package lotto.domain;

import java.util.List;
import lotto.constants.messages.ExceptionMessage;
import lotto.constants.utils.MessageFormatUtil;
import lotto.constants.utils.NumberUtil;
import lotto.constants.utils.RegularExpressionUtil;

public class WinningNumberValidator {
    public static final int MAXIMUM_NUMBER = 45;
    public static final int MINIMUM_NUMBER = 1;

    public void validateWinningLottoNumber(String winningLottoNumber) {
        if (!winningLottoNumber.matches(RegularExpressionUtil.LOTTO_NUMBER_CHECK)) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_FORMAT_ERROR);
        }
        if (isDuplicatedNumber(List.of(winningLottoNumber.split(MessageFormatUtil.COMMA)))) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBER);
        }
        if (isOutOfBounds(List.of(winningLottoNumber.split(MessageFormatUtil.COMMA)))) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_BOUNDS);
        }
    }

    private boolean isOutOfBounds(List<String> splitWinningLottoNumber) {
        return getMaximumNumber(splitWinningLottoNumber) > MAXIMUM_NUMBER
                || getMinimumNumber(splitWinningLottoNumber) < MINIMUM_NUMBER;
    }

    private int getMinimumNumber(List<String> splitWinningLottoNumber) {
        return splitWinningLottoNumber.stream()
                .map(Integer::parseInt)
                .min(Integer::compareTo)
                .get();
    }

    private int getMaximumNumber(List<String> splitWinningLottoNumber) {
        return splitWinningLottoNumber.stream()
                .map(Integer::parseInt)
                .max(Integer::compareTo)
                .get();
    }

    private boolean isDuplicatedNumber(List<String> splitWinningLottoNumber) {
        return splitWinningLottoNumber.stream()
                .distinct()
                .count() != NumberUtil.LOTTO_NUMBER_COUNT;
    }

    public void validateBonusNumber(String bonusNumber, List<Integer> numbers) {
        if (!bonusNumber.matches(RegularExpressionUtil.BONUS_NUMBER_CHECK)) {
            throw new IllegalArgumentException(ExceptionMessage.NON_NUMERIC_INPUT);
        }
        if (Integer.parseInt(bonusNumber) < MINIMUM_NUMBER || Integer.parseInt(bonusNumber) > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_BOUNDS);
        }
        if (numbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_NUMBER);
        }
    }
}
