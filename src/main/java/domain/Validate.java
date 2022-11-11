package domain;

import java.util.regex.Pattern;

import static domain.ErrorMessage.*;

public class Validate {

    public void validateMoney(String input) {
        isNumber(input);
        isEnoughMoney(input);
    }

    private void isEnoughMoney(String input) {
        int money = Integer.parseInt(input);
        if (money % ConstantNumber.VALID_MONEY.getNumber() != 0) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY_ERROR.getMessage());
        }
    }

    private void isNumber(String input) {
        String regex = "^[0-9]*$";
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR.getMessage());
        }
    }
}
