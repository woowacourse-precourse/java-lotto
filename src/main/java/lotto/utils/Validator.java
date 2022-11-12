package lotto.utils;

import java.util.regex.Pattern;
import lotto.domain.ErrorMessage;

public class Validator {
    private static final String INPUT_NUMBER_REGEX = "^[0-9]*$";
    public void isValidMoney(String input) {
        if(!isNumber(input)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_NOT_NUMBER.getMessage());
        }
        if(isZero(input)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_ZERO.getMessage());
        }
        if(isEnteredSpace(input)){
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_NOT_ENTERED.getMessage());
        }
        if(!is1000Units(Integer.parseInt(input))) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_NOT_1000_UNIT.getMessage());
        }
    }

    private boolean isNumber(String input) {
        Pattern numberPattern = Pattern.compile(INPUT_NUMBER_REGEX);
        return numberPattern.matcher(input).matches();
    }

    private boolean isZero(String input) {
        return input.equals("0");
    }

    private boolean isEnteredSpace(String input) {
        return input.equals("");
    }

    private boolean is1000Units(int money) {
        return money % 1000 == 0;
    }
}
