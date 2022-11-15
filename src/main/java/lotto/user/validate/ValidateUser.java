package lotto.user.validate;

import java.util.regex.Pattern;
import lotto.user.domain.User;
import lotto.util.Constant;

public class ValidateUser {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]+[0-9]*$");

    public static void validateMinAmount(int inputMoney) {
        if (inputMoney < Constant.UNIT_MONEY) {
            throw new IllegalArgumentException(Constant.ERROR_MESSAGE_HEAD+"최소 금액은 "+Constant.UNIT_MONEY+"원 이상입니다");
        }
    }

    public static void validateOnlyNumber(String userInput) {
        if (!NUMBER_PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException(Constant.INPUT_ERROR_MESSAGE);
        }
    }

}
