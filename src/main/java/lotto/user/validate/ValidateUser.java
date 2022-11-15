package lotto.user.validate;

import static lotto.util.Constant.CHECK_ZERO;

import java.util.regex.Pattern;
import lotto.util.Constant;


public class ValidateUser {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]+[0-9]*$");

    public static void validateMoneyOnlyNumber(String userInput) {
        if (!NUMBER_PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException(Constant.INPUT_MONEY_ERROR_MESSAGE);
        }
    }

    public static void validateDivideByUnit(int inputMoney) {
        if ((inputMoney % Constant.UNIT_MONEY) != CHECK_ZERO) {
            throw new IllegalArgumentException(
                    Constant.ERROR_MESSAGE_HEAD + " 입금액의 최소 단위는 " + Constant.UNIT_MONEY + "원 입니다.");
        }
    }

}
