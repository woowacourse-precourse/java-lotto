package lotto.view;

import lotto.util.ErrorMessage;
import java.util.Arrays;
import java.util.regex.Pattern;

public class ViewValidator {
    private static final String INVALID_NUMBER_TYPE_REGEX = "\\D";
    private static final int UNIT_OF_MONEY = 1000;

    public void validateEmptyString(String number) {
        if (number.equals("")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_TYPE.getMessage());
        }
    }

    public void validateNumberType(String number) {
        if (Pattern.compile(INVALID_NUMBER_TYPE_REGEX).matcher(number).find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_TYPE.getMessage());
        }
    }

    public void validateUnitOf1000(String money) {
        if (Long.parseLong(money) % UNIT_OF_MONEY != 0L) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_UNIT_OF_MONEY.getMessage());
        }
    }

    public void validateMoneyIsZero(String money) {
        if (Long.parseLong(money) == 0L) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_ZERO.getMessage());
        }
    }

    public void validateNumbersType(String numbers) {
        Arrays.stream(numbers.split(","))
                .forEach(this::validateNumberType);
    }
}
