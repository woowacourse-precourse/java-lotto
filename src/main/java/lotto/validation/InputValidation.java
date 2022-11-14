package lotto.validation;

import static lotto.constant.ExceptionConstant.NUMBER_INPUT_ERROR;
import static lotto.constant.ExceptionConstant.PRICE_ERROR;
import static lotto.constant.LottoConstant.PRICE;

public class InputValidation {

    public static boolean isNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException(NUMBER_INPUT_ERROR.getMessage());
        }
        return true;
    }

    public static boolean isValidUnit(int userInput) {
        if (userInput % PRICE.getValue() == 0) {
            return true;
        }
        throw new IllegalArgumentException(PRICE_ERROR.getMessage());
    }
}
