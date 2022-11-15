package lotto.validator;

import lotto.constants.messages.ExceptionMessage;
import lotto.constants.utils.NumberUtil;
import lotto.constants.utils.RegularExpressionUtil;

public class InputValidator {
    public static final int LOTTO_PRICE = 1000;
    public static final int FIRST_INDEX = 0;

    public boolean validateInputPrice(String inputPrice) {
        if (!inputPrice.matches(RegularExpressionUtil.ONLY_NUMBER_CHECK)) {
            throw new IllegalArgumentException(ExceptionMessage.NON_NUMERIC_INPUT);
        }
        if (isZero(Integer.parseInt(inputPrice))) {
            throw new IllegalArgumentException(ExceptionMessage.ZERO_INPUT);
        }
        if (isStartWithZero(inputPrice.charAt(FIRST_INDEX))) {
            throw new IllegalArgumentException(ExceptionMessage.START_WItH_ZERO);
        }
        return isNotValidPrice(Integer.parseInt(inputPrice));
    }

    private boolean isStartWithZero(char firstNumber) {
        return Integer.parseInt(String.valueOf(firstNumber)) == NumberUtil.ZERO;
    }

    private boolean isZero(int inputPrice) {
        return inputPrice == NumberUtil.ZERO;
    }

    private boolean isNotValidPrice(int inputPrice) {
        return inputPrice % LOTTO_PRICE != NumberUtil.ZERO;
    }
}
