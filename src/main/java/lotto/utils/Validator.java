package lotto.utils;

import java.util.regex.Pattern;
import lotto.domain.ErrorMessage;

public class Validator {
    private static final String INPUT_NUMBER_REGEX = "^[0-9]*$";
    private static final String INPUT_ZERO_NUMBER_REGEX = "^[0]*$";
    public void isValidMoney(String inputMoney) {
        if(!isNumber(inputMoney)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_NOT_NUMBER.getMessage());
        }
        if(isEnteredSpace(inputMoney)){
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_NOT_ENTERED.getMessage());
        }
        if(isZero(inputMoney)) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_ZERO.getMessage());
        }
        if(!is1000Units(Integer.parseInt(inputMoney))) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_NOT_1000_UNIT.getMessage());
        }
    }

    private boolean isNumber(String input) {
        Pattern numberPattern = Pattern.compile(INPUT_NUMBER_REGEX);
        return numberPattern.matcher(input).matches();
    }

    private boolean isZero(String input) {
        Pattern numberPattern = Pattern.compile(INPUT_ZERO_NUMBER_REGEX);
        return numberPattern.matcher(input).matches();
    }

    private boolean isEnteredSpace(String input) {
        return input.equals("");
    }

    private boolean is1000Units(int money) {
        return money % 1000 == 0;
    }
}
