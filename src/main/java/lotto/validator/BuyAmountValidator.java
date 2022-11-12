package lotto.validator;

import static lotto.utils.LottoConstant.LOTTO_PRICE;

public class BuyAmountValidator {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String CONVERT_ERROR_MESSAGE = "숫자로 변환 할 수 없습니다.";
    private static final String DIVIDE_ERROR_MESSAGE = "1000으로 나눌 수 없는 숫자를 입력했습니다.";
    private static final String NEGATIVE_INPUT_MESSAGE = "음수를 입력했습니다.";

    public void validateInputNumber(String inputNumber) {
        validateInvalidNumber(inputNumber);
        validateDivideBy1000(inputNumber);
        validatePositiveNumber(inputNumber);
    }

    public void validateInvalidNumber(String inputNumber) throws IllegalArgumentException {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + CONVERT_ERROR_MESSAGE);
        }
    }


    public void validateDivideBy1000(String inputNumber) {
        int number = Integer.parseInt(inputNumber);
        if (!divideBy1000(number)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + DIVIDE_ERROR_MESSAGE);
        }
    }

    public void validatePositiveNumber(String inputNumber) {
        int number = Integer.parseInt(inputNumber);
        if (number < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NEGATIVE_INPUT_MESSAGE);
        }
    }

    private boolean divideBy1000(int inputNumber) {
        return inputNumber % LOTTO_PRICE == 0;
    }
}
